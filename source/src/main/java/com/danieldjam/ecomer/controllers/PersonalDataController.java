package com.danieldjam.ecomer.controllers;

import com.danieldjam.ecomer.models.dto.PersonalDataDTO;
import com.danieldjam.ecomer.service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal")
public class PersonalDataController {


    @Autowired
    private PersonalDataService personalDataService;

    @PostMapping
    public ResponseEntity<PersonalDataDTO> createPersonalData(@RequestBody PersonalDataDTO personalDataDTO){
        return new ResponseEntity<>(personalDataService.createPersonalData(personalDataDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PersonalDataDTO> getPersonalData(){
        return personalDataService.getPersonalData();
    }

}
