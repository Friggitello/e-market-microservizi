package com.givuli.commerce.user.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ComuneRequest(
        @NotBlank
        String nome
) {
}
