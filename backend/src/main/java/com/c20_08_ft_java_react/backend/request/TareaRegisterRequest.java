package com.c20_08_ft_java_react.backend.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.sql.Date;

public record TareaRegisterRequest(
        @NotBlank String nombreTarea,
        @NotBlank String asunto,
        @NotBlank Date fechaexp;

) {
}
