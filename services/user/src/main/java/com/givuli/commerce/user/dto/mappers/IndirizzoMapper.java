package com.givuli.commerce.user.dto.mappers;

import com.givuli.commerce.user.dto.requests.IndirizzoRequest;
import com.givuli.commerce.user.dto.responses.IndirizzoResponse;
import com.givuli.commerce.user.entities.Indirizzo;
import com.givuli.commerce.user.services.ComuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndirizzoMapper {

    @Autowired
    ComuneService comuneService;

    public IndirizzoResponse toResponse(Indirizzo indirizzo){
        return IndirizzoResponse
                .builder()
                .id(indirizzo.getId())
                .via(indirizzo.getVia())
                .civico(indirizzo.getCivico())
                .cap(indirizzo.getCap())
                .utenteId(indirizzo.getUtente().getId())
                .comuneId(indirizzo.getComune().getId())
                .build();
    }

    public Indirizzo toEntity(IndirizzoRequest request){
        return Indirizzo
                .builder()
                .via(request.via())
                .civico(request.civico())
                .cap(request.cap())
                .comune(comuneService.getComuneById(request.comuneId()))
                .build();
    }
}
