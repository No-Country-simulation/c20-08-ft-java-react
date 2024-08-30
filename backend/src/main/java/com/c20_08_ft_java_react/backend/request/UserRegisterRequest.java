package com.c20_08_ft_java_react.backend.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegisterRequest(
        @NotBlank String username,
        @NotBlank String password,
        @NotBlank @Email String email
) {
}
