package com.book.service;

import com.book.models.User;

public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
