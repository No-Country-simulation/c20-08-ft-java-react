package com.c20_08_ft_java_react.backend.request;


public record UserRegisterRequest(
        String username,
        String password,
        String email
) {
}
