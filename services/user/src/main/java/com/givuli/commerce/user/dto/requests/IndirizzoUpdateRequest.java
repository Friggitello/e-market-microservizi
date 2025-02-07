package com.givuli.commerce.user.dto.requests;

import lombok.Builder;

@Builder
public record IndirizzoUpdateRequest(
        String via,
        String civico,
        String cap,
        Long comuneId
) {
}
