# Basic Authentication with Spring Boot + Spring Security + Keycloak

A demo project to demonstrate how to use Spring Boot, Keycloak and Spring Security to implement Basic Authentication

## Description

This app only has one dummy endpoint. To send request, the client needs to authenticate.

| HTTP Method  | Endpoint |
| --- | --- |
| GET  | /books  |

Basic Authentication performed by Keycloack, which runs on port 8089.

## Environment Setup

A ```docker-compose``` file can be found in the src/main/docker folder, which can be used to get Keycloak up and running for this project. Simply run:

```docker-compose up -d```
