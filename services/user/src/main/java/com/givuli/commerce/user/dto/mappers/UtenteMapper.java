package com.givuli.commerce.user.dto.mappers;

import com.givuli.commerce.user.dto.requests.UtenteRequest;
import com.givuli.commerce.user.dto.responses.UtenteResponse;
import com.givuli.commerce.user.entities.Indirizzo;
import com.givuli.commerce.user.entities.Utente;
import org.springframework.stereotype.Service;

@Service
public class UtenteMapper {
    public UtenteResponse toResponse(Utente utente){
        return UtenteResponse
                .builder()
                .id(utente.getId())
                .nome(utente.getNome())
                .cognome(utente.getCognome())
                .email(utente.getEmail())
                .dataNascita(utente.getDataNascita())
                .indirizziId(utente.getIndirizzi()
                        .stream()
                        .map(Indirizzo::getId)
                        .toList())
                .build();
    }

    public Utente toEntity(UtenteRequest request){
        return Utente
                .builder()
                .nome(request.nome())
                .cognome(request.cognome())
                .email(request.email())
                .dataNascita(request.dataNascita())
                .build();
    }
}
