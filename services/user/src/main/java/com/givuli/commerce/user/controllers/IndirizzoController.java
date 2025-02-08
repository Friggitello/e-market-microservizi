package com.givuli.commerce.user.controllers;

import com.givuli.commerce.user.dto.requests.IndirizzoRequest;
import com.givuli.commerce.user.dto.requests.IndirizzoUpdateRequest;
import com.givuli.commerce.user.dto.responses.EntityIdResponse;
import com.givuli.commerce.user.dto.responses.GenericResponse;
import com.givuli.commerce.user.dto.responses.IndirizzoResponse;
import com.givuli.commerce.user.services.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/indirizzi")
public class IndirizzoController {
    @Autowired
    IndirizzoService indirizzoService;

    @GetMapping("/get/{id}")
    public ResponseEntity<IndirizzoResponse> getIndirizzoById(@PathVariable Long id){
        return new ResponseEntity<>(indirizzoService.getIndirizzoByIdToResponse(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<IndirizzoResponse>> getAllIndirizzi(){
        return new ResponseEntity<>(indirizzoService.getAllToResponse(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EntityIdResponse> createIndirizzo(@RequestBody IndirizzoRequest request){
        return new ResponseEntity<>(indirizzoService.createIndirizzo(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EntityIdResponse> updateIndirizzo(@PathVariable Long id, @RequestBody IndirizzoUpdateRequest request){
        return new ResponseEntity<>(indirizzoService.updateIndirizzo(id, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse> deleteIndirizzo(@PathVariable Long id){
        return new ResponseEntity<>(indirizzoService.deleteIndirizzoById(id), HttpStatus.OK);
    }
}
