package com.givuli.commerce.user.services;

import com.givuli.commerce.user.dto.mappers.IndirizzoMapper;
import com.givuli.commerce.user.dto.mappers.UtenteMapper;
import com.givuli.commerce.user.dto.requests.IndirizzoRequest;
import com.givuli.commerce.user.dto.requests.UtenteRequest;
import com.givuli.commerce.user.dto.requests.UtenteUpdateRequest;
import com.givuli.commerce.user.dto.responses.EntityIdResponse;
import com.givuli.commerce.user.dto.responses.GenericResponse;
import com.givuli.commerce.user.dto.responses.IndirizzoResponse;
import com.givuli.commerce.user.dto.responses.UtenteResponse;
import com.givuli.commerce.user.entities.Indirizzo;
import com.givuli.commerce.user.entities.Utente;
import com.givuli.commerce.user.exceptions.UtenteNotFoundException;
import com.givuli.commerce.user.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {
    @Autowired
    UtenteRepository utenteRepository;
    @Autowired
    UtenteMapper utenteMapper;
    @Autowired
    IndirizzoService indirizzoService;
    @Autowired
    IndirizzoMapper indirizzoMapper;

    public UtenteResponse getUtenteById(Long id){
        Utente utente = utenteRepository.findById(id).orElseThrow(() -> new UtenteNotFoundException(String.format("Utente con id %d non trovato", id)));
        return utenteMapper.toResponse(utente);
    }

    public List<UtenteResponse> getAll(){
        return utenteRepository
                .findAll().
                stream()
                .map(utenteMapper::toResponse)
                .toList();
    }

    public EntityIdResponse createUtente(UtenteRequest request){
        Utente utente = utenteRepository.save(utenteMapper.toEntity(request));
        return EntityIdResponse
                .builder()
                .id(utente.getId())
                .build();
    }

    public EntityIdResponse updateUtente(Long id, UtenteUpdateRequest request){
        Utente utente = utenteRepository.findById(id).orElseThrow(() -> new UtenteNotFoundException(String.format("Utente con id %d non trovato", id)));
        if (request.nome() != null) utente.setNome(request.nome());
        if (request.cognome() != null) utente.setCognome(request.cognome());
        if (request.dataNascita() != null) utente.setDataNascita(request.dataNascita());
        if (request.email() != null) utente.setEmail(request.email());
        utenteRepository.save(utente);
        return EntityIdResponse
                .builder()
                .id(utente.getId())
                .build();
    }

    public GenericResponse deleteUtenteById(Long id){
        utenteRepository.deleteById(id);
        return GenericResponse
                .builder()
                .message(String.format("Utente con id %d cancellato", id))
                .build();
    }

    public EntityIdResponse aggiungiIndirizzo(Long idUtente, IndirizzoRequest request){
        Utente utente = utenteRepository
                .findById(idUtente)
                .orElseThrow(() -> new UtenteNotFoundException(String.format("Utente con id %d non trovato", idUtente)));
        Indirizzo indirizzo = indirizzoMapper.toEntity(request);
        indirizzo.setUtente(utente);
        indirizzoService.createIndirizzo(indirizzo);
        List<Indirizzo> indirizziUtente = utente.getIndirizzi();
        indirizziUtente.add(indirizzo);
        utenteRepository.save(utente);
        return EntityIdResponse.builder().id(indirizzo.getId()).build();
    }

    public GenericResponse rimuoviIndirizzo(Long idUtente, Long idIndirizzo){
        Utente utente = utenteRepository
                .findById(idUtente)
                .orElseThrow(() -> new UtenteNotFoundException(String.format("Utente con id %d non trovato", idUtente)));
        Indirizzo indirizzo = indirizzoService.getIndirizzoById(idIndirizzo);
        List<Indirizzo> indirizziUtente = utente.getIndirizzi();
        indirizziUtente.remove(indirizzo);
        indirizzoService.deleteIndirizzoById(indirizzo.getId());
        utenteRepository.save(utente);
        return GenericResponse
                .builder()
                .message(String.format("Indirizzo %d rimosso da Utente %d",idIndirizzo,idUtente))
                .build();
    }

    public List<IndirizzoResponse> getIndirizziByUtente(Long id){
        Utente utente = utenteRepository
                .findById(id)
                .orElseThrow(() -> new UtenteNotFoundException(String.format("Utente con id %d non trvoato", id)));
        return utente.getIndirizzi().stream().map(indirizzoMapper::toResponse).toList();
    }
}
