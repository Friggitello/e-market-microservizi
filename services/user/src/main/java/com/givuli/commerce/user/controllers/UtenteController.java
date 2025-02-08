package com.givuli.commerce.user.controllers;

import com.givuli.commerce.user.dto.requests.IndirizzoRequest;
import com.givuli.commerce.user.dto.requests.UtenteRequest;
import com.givuli.commerce.user.dto.requests.UtenteUpdateRequest;
import com.givuli.commerce.user.dto.responses.EntityIdResponse;
import com.givuli.commerce.user.dto.responses.GenericResponse;
import com.givuli.commerce.user.dto.responses.IndirizzoResponse;
import com.givuli.commerce.user.dto.responses.UtenteResponse;
import com.givuli.commerce.user.services.UtenteService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/utenti")
public class UtenteController {

    @Autowired
    UtenteService utenteService;

    @GetMapping("/get/{id}")
    public ResponseEntity<UtenteResponse> getUtenteById(@PathVariable Long id){
        return new ResponseEntity<>(utenteService.getUtenteById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UtenteResponse>> getAllUtenti(){
        return new ResponseEntity<>(utenteService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EntityIdResponse> createUtente(@RequestBody UtenteRequest request){
        return new ResponseEntity<>(utenteService.createUtente(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EntityIdResponse> updateUtente(@PathVariable Long id, @RequestBody UtenteUpdateRequest request){
        return new ResponseEntity<>(utenteService.updateUtente(id, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse> deleteUtente(@PathVariable Long id){
        return new ResponseEntity<>(utenteService.deleteUtenteById(id), HttpStatus.OK);
    }

    @PostMapping("/add-indirizzo/{idUtente}")
    public ResponseEntity<EntityIdResponse> addIndirizzo(@PathVariable Long idUtente, @RequestBody IndirizzoRequest request){
        return new ResponseEntity<>(utenteService.aggiungiIndirizzo(idUtente, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-indirizzo/{idUtente}/{idIndirizzo}")
    public ResponseEntity<GenericResponse> deleteIndirizzo(@PathVariable Long idUtente, @PathVariable Long idIndirizzo){
        return new ResponseEntity<>(utenteService.rimuoviIndirizzo(idUtente,idIndirizzo), HttpStatus.CREATED);
    }

    @GetMapping("/all-indirizzi/{id}")
    public ResponseEntity<List<IndirizzoResponse>> getAllIndirizzi(@PathVariable Long id){
        return new ResponseEntity<>(utenteService.getIndirizziByUtente(id), HttpStatus.OK);
    }
}
