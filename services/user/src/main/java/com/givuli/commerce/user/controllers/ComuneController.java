package com.givuli.commerce.user.controllers;

import com.givuli.commerce.user.dto.requests.ComuneRequest;
import com.givuli.commerce.user.dto.requests.ComuneUpdateRequest;
import com.givuli.commerce.user.dto.responses.ComuneResponse;
import com.givuli.commerce.user.dto.responses.EntityIdResponse;
import com.givuli.commerce.user.dto.responses.GenericResponse;
import com.givuli.commerce.user.dto.responses.UtenteResponse;
import com.givuli.commerce.user.services.ComuneService;
import com.givuli.commerce.user.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comuni")
public class ComuneController {

    @Autowired
    ComuneService comuneService;

    @GetMapping("/get/{id}")
    public ResponseEntity<ComuneResponse> getComuneById(@PathVariable Long id){
        return new ResponseEntity<>(comuneService.getComuneByIdToResponse(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ComuneResponse>> getAllComuni(){
        return new ResponseEntity<>(comuneService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EntityIdResponse> createComune(@RequestBody ComuneRequest request){
        return new ResponseEntity<>(comuneService.createComune(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EntityIdResponse> updateComune(@PathVariable Long id, @RequestBody ComuneUpdateRequest request){
        return new ResponseEntity<>(comuneService.updateComune(id, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse> deleteComune(@PathVariable Long id){
        return new ResponseEntity<>(comuneService.deleteComuneById(id), HttpStatus.OK);
    }
}
