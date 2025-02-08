package com.givuli.commerce.user.dto.responses;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record UtenteResponse(
        Long id,
        String nome,
        String cognome,
        LocalDate dataNascita,
        String email,
        List<Long> indirizziId
) {
}
