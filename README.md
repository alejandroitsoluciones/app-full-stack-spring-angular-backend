# App FullStack With Spring And Angular

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.5/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.5/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.5/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.5/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.5.5/reference/htmlsingle/#boot-features-security)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Create User
```
POST /api/v1/auth/register HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 87

{
    "name": "user_name",
    "username": "username",
    "password": "password"
}
```

### Login

```
POST /api/v1/auth/login HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 55

{
    "username": "userI",
    "password": "passI"
}
```

### Update User As Admin
```
PUT /api/v1/internal/make-admin/username HTTP/1.1
Host: localhost:8080
Authorization: Bearer 2D8A3E9BEF5790135D9550B0188CDE2FD876DF51F5A0E72F48997B83FB758A80
```

### List All Books

```
GET /api/v1/books HTTP/1.1
Host: localhost:8080
```

### Save Book

```
POST /api/v1/books HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkkiLCJyb2xlcyI6IlJPTEVfQURNSU4iLCJ1c2VySWQiOjIsImV4cCI6MTYzMzgwMzQ4OH0.JdCHUcibxqdzHscbmaFoPW350dR6URqfGWkA7cAuUwYSMbNkACvY_LwgcSYMY1A9b2JEDgfkTKaIQzyF6B7LQw
Content-Type: application/json
Content-Length: 121

{
    "title": "bookIII",
    "price": 65.6,
    "description": "this is a thrith book",
    "author": "authorIII"
}
```

### Delete Book

```
DELETE /api/v1/books/{id} HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkkiLCJyb2xlcyI6IlJPTEVfQURNSU4iLCJ1c2VySWQiOjIsImV4cCI6MTYzMzgwMzQ4OH0.JdCHUcibxqdzHscbmaFoPW350dR6URqfGWkA7cAuUwYSMbNkACvY_LwgcSYMY1A9b2JEDgfkTKaIQzyF6B7LQw
```

### Get All Purchases Of The User

```
GET /api/v1/purchase-history HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VySSIsInJvbGVzIjoiUk9MRV9VU0VSIiwidXNlcklkIjoxLCJleHAiOjE2MzM4MDM5NjB9.mSGCo6kTBVTF0P5b8uy2LnqMzDfmG5FKdt9XxUEI9BjLEIlB87oq6_oBxEpxKqIIMb4mzgaCui7BDUQO9p-Cfw
```

### Save Purchase

```
POST /api/v1/purchase-history HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VySSIsInJvbGVzIjoiUk9MRV9VU0VSIiwidXNlcklkIjoxLCJleHAiOjE2MzM4MDM5NjB9.mSGCo6kTBVTF0P5b8uy2LnqMzDfmG5FKdt9XxUEI9BjLEIlB87oq6_oBxEpxKqIIMb4mzgaCui7BDUQO9p-Cfw
Content-Type: application/json
Content-Length: 57

{
    "userId": 1,
    "bookId": 1,
    "price": 10
}
```