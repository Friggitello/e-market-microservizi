package com.givuli.commerce.user.services;

import com.givuli.commerce.user.dto.mappers.ComuneMapper;
import com.givuli.commerce.user.dto.requests.ComuneRequest;
import com.givuli.commerce.user.dto.requests.ComuneUpdateRequest;
import com.givuli.commerce.user.dto.responses.ComuneResponse;
import com.givuli.commerce.user.dto.responses.EntityIdResponse;
import com.givuli.commerce.user.dto.responses.GenericResponse;
import com.givuli.commerce.user.entities.Comune;
import com.givuli.commerce.user.entities.Indirizzo;
import com.givuli.commerce.user.exceptions.ComuneNotFoundException;
import com.givuli.commerce.user.repositories.ComuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComuneService {
    @Autowired
    ComuneRepository comuneRepository;

    @Autowired
    ComuneMapper comuneMapper;
    public Comune getComuneById(Long id){
        return comuneRepository
                .findById(id)
                .orElseThrow(() -> new ComuneNotFoundException(String.format("Comune con id %d non trovato", id)));
    }

    public ComuneResponse getComuneByIdToResponse(Long id){
        Comune comune = comuneRepository
                .findById(id)
                .orElseThrow(() -> new ComuneNotFoundException(String.format("Comune con id %d non trovato", id)));
        return comuneMapper.toResponse(comune);
    }

    public List<ComuneResponse> getAll(){
        return comuneRepository
                .findAll()
                .stream()
                .map(comuneMapper::toResponse)
                .toList();
    }

    public EntityIdResponse createComune(ComuneRequest request){
        Comune comune = comuneRepository.save(comuneMapper.toEntity(request));
        return EntityIdResponse
                .builder()
                .id(comune.getId())
                .build();
    }

    public EntityIdResponse updateComune(Long id, ComuneUpdateRequest request){
        Comune comune = comuneRepository
                .findById(id)
                .orElseThrow(() -> new ComuneNotFoundException(String.format("Comune con id %d non trovato", id)));
        if (request.nome() != null) comune.setNome(request.nome());
        comuneRepository.save(comune);
        return EntityIdResponse
                .builder()
                .id(comune.getId())
                .build();
    }

    public GenericResponse deleteComuneById(Long id){
        comuneRepository.deleteById(id);
        return GenericResponse.builder().message(String.format("Comune con id %d cancellato", id)).build();
    }
}
