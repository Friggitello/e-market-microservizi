package com.givuli.commerce.user.dto.responses;

import lombok.Builder;

@Builder
public record IndirizzoResponse(
        Long id,
        String via,
        String civico,
        String cap,
        Long utenteId,
        Long comuneId
) {
}
