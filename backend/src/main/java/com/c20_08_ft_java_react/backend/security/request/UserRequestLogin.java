package com.c20_08_ft_java_react.backend.security.request;

import jakarta.validation.constraints.NotBlank;

public record UserRequestLogin (
        @NotBlank String username, @NotBlank String password
){
}
