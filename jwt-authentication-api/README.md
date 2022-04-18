# Jwt Authentication with Spring Boot + Spring Security

A demo project to demonstrate how to use Spring Boot and Spring Security to implement Jwt Authentication

## Description

This app only has one dummy endpoint. To send request, the client needs to authenticate.

| HTTP Method  | Endpoint |
| --- | --- |
| GET  | /books  |

- To generate Jwt Token https://jwt.io/
- To generate Private / Public key value pair https://gist.github.com/ygotthilf/baa58da5c3dd1f69fae9
```
ssh-keygen -t rsa -b 4096 -m PEM -f jwtRS256.key
openssl rsa -in jwtRS256.key -pubout -outform PEM -out jwtRS256.key.pub
cat jwtRS256.key
cat jwtRS256.key.pub
```