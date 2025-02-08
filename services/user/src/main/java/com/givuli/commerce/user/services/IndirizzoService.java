package com.givuli.commerce.user.services;

import com.givuli.commerce.user.dto.mappers.IndirizzoMapper;
import com.givuli.commerce.user.dto.requests.IndirizzoRequest;
import com.givuli.commerce.user.dto.requests.IndirizzoUpdateRequest;
import com.givuli.commerce.user.dto.responses.EntityIdResponse;
import com.givuli.commerce.user.dto.responses.GenericResponse;
import com.givuli.commerce.user.dto.responses.IndirizzoResponse;
import com.givuli.commerce.user.entities.Indirizzo;
import com.givuli.commerce.user.exceptions.IndirizzoNotFoundException;
import com.givuli.commerce.user.repositories.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndirizzoService {
    @Autowired
    IndirizzoRepository indirizzoRepository;
    @Autowired
    IndirizzoMapper indirizzoMapper;
    @Autowired
    ComuneService comuneService;

    public Indirizzo getIndirizzoById(Long id){
        return indirizzoRepository
                .findById(id)
                .orElseThrow(() -> new IndirizzoNotFoundException(String.format("Indirizzo con id %d non trovato", id)));
    }

    public IndirizzoResponse getIndirizzoByIdToResponse(Long id){
        Indirizzo indirizzo = indirizzoRepository
                .findById(id)
                .orElseThrow(() -> new IndirizzoNotFoundException(String.format("Indirizzo con id %d non trovato", id)));
        return indirizzoMapper.toResponse(indirizzo);
    }

    public List<Indirizzo> getAll(){
        return indirizzoRepository
                .findAll()
                .stream()
                .toList();
    }

    public List<IndirizzoResponse> getAllToResponse(){
        return indirizzoRepository.findAll().stream().map(indirizzoMapper::toResponse).toList();
    }

    public EntityIdResponse createIndirizzo(IndirizzoRequest request){
        Indirizzo indirizzo = indirizzoRepository.save(indirizzoMapper.toEntity(request));
        return EntityIdResponse
                .builder()
                .id(indirizzo.getId())
                .build();
    }

    public EntityIdResponse updateIndirizzo(Long id, IndirizzoUpdateRequest request){
        Indirizzo indirizzo = indirizzoRepository
                .findById(id)
                .orElseThrow(() -> new IndirizzoNotFoundException(String.format("Indirizzo con id %d non trovato", id)));
        if (request.via() != null) indirizzo.setVia(request.via());
        if (request.civico() != null) indirizzo.setCivico(request.civico());
        if (request.cap() != null) indirizzo.setCap(request.cap());
        if (request.comuneId() != null) indirizzo.setComune(comuneService.getComuneById(request.comuneId()));
        indirizzoRepository.save(indirizzo);
        return EntityIdResponse
                .builder()
                .id(indirizzo.getId())
                .build();
    }

    public GenericResponse deleteIndirizzoById(Long id){
        indirizzoRepository.deleteById(id);
        return GenericResponse
                .builder()
                .message(String.format("Indirizzo con id %d cancellato", id))
                .build();
    }
}
