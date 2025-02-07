package com.givuli.commerce.user.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record IndirizzoRequest(
        @NotBlank
        String via,
        @NotBlank
        String civico,
        @NotBlank
        String cap,
        @NotNull
        Long comuneId
) {
}
