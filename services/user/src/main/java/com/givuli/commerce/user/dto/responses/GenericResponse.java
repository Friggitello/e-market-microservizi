package com.givuli.commerce.user.dto.responses;

import lombok.Builder;

@Builder
public record GenericResponse(
        String message
) {
}
