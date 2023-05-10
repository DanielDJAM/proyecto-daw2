package com.danieldjam.ecomer.controllers;

import com.danieldjam.ecomer.models.dto.AddressDTO;
import com.danieldjam.ecomer.models.dto.PersonalDataDTO;
import com.danieldjam.ecomer.service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personaldata")
public class PersonalDataController {


    @Autowired
    private PersonalDataService personalDataService;

    @PostMapping
    public ResponseEntity<PersonalDataDTO> createPersonalData(@RequestBody PersonalDataDTO personalDataDTO){
        return new ResponseEntity<>(personalDataService.createPersonalData(personalDataDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PersonalDataDTO> getAllPersonalData(){
        return personalDataService.getAllPersonalData();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<PersonalDataDTO> getPersonalDataById(@PathVariable String dni) { return new ResponseEntity<>(personalDataService.getPersonalDataById(dni), HttpStatus.OK);}

    @PutMapping("/{dni}")
    public ResponseEntity<PersonalDataDTO> editPersonalDataById(@PathVariable String dni, @RequestBody PersonalDataDTO personalDataDTO) {
        return new ResponseEntity<>(personalDataService.updatePersonalData(dni, personalDataDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> deletePersonalDataById(@PathVariable String dni){
        personalDataService.deletePersonalDataById(dni);
        return ResponseEntity.noContent().build();
    }

}
