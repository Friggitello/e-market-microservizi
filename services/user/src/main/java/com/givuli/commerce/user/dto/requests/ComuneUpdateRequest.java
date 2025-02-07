package com.givuli.commerce.user.dto.requests;

import lombok.Builder;

@Builder
public record ComuneUpdateRequest(
        String nome
) {
}
