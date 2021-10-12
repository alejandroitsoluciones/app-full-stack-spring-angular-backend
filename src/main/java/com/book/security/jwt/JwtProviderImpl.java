package com.book.security.jwt;

import com.book.security.UserDetailsImpl;
import com.book.util.SecurityUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtProviderImpl implements JwtProvider{

//    @Value("${app.jwt.secret}") Never Use Like This. Only For Demo
    private static String JWT_SECRET = "E16788EA0CA0F14DFCC731C44943C1E30D8C3AEF55A6246909B472F14A588A25";

//    @Value("${app.jwt.expiration-in-ms}") Never Use Like This. Only For Demo
    private static Long JWT_EXPIRATION_TIME = Long.valueOf(3600000);

    @Override
    public String generateToken(UserDetailsImpl auth){

        String authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(auth.getUsername())
                .claim("roles", authorities)
                .claim("userId", auth.getId())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();

    }

    @Override
    public Authentication getAuthentication(HttpServletRequest request){
        Claims claims = extratClaims(request);
        if (claims == null){
            return null;
        }
        String username = claims.getSubject();
        Long userId = claims.get("userId", Long.class);
        Set<GrantedAuthority> authorities = Arrays.stream(claims.get("roles").toString().split(","))
                .map(SecurityUtils::convertToAuthority)
                .collect(Collectors.toSet());
        UserDetails userDetails = UserDetailsImpl.builder()
                .username(username)
                .authorities(authorities)
                .id(userId)
                .build();

        if (username == null){
            return null;
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
    }

    @Override
    public boolean validateToken(HttpServletRequest request){
        Claims claims = extratClaims(request);
        if (claims == null){
            return false;
        }
        if (claims.getExpiration().before(new Date())){
            return false;
        }
        return true;
    }

    private Claims extratClaims(HttpServletRequest request){
        String token = SecurityUtils.extractAuthTokenFromRequest(request);
        if (token == null){
            return null;
        }
        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

}
