package com.givuli.commerce.user.dto.mappers;

import com.givuli.commerce.user.dto.requests.ComuneRequest;
import com.givuli.commerce.user.dto.responses.ComuneResponse;
import com.givuli.commerce.user.entities.Comune;
import org.springframework.stereotype.Service;

@Service
public class ComuneMapper {
    public ComuneResponse toResponse(Comune comune){
        return ComuneResponse
                .builder()
                .id(comune.getId())
                .nome(comune.getNome())
                .build();
    }
    public Comune toEntity(ComuneRequest request){
        return Comune
                .builder()
                .nome(request.nome())
                .build();
    }
}
