package com.givuli.commerce.user.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UtenteRequest(
        @NotBlank
        String nome,
        @NotBlank
        String cognome,
        @NotNull
        @Past
        LocalDate dataNascita,
        @NotNull
        @Email
        String email
) {
}
