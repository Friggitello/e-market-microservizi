package com.givuli.commerce.user.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UtenteUpdateRequest(
        String nome,
        String cognome,
        @Past
        LocalDate dataNascita,
        @Email
        String email
) {
}
