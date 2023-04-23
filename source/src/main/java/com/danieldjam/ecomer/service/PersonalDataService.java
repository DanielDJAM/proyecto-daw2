package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.PersonalDataDTO;
import com.danieldjam.ecomer.models.entities.PersonalData;

import java.util.List;

public interface PersonalDataService {

    public PersonalDataDTO createPersonalData(PersonalDataDTO personalDataDTO);

    public List<PersonalDataDTO> getAllPersonalData();

    public PersonalDataDTO getPersonalDataById(String dni);

    public PersonalDataDTO updatePersonalData(String dni, PersonalDataDTO personalDataDTO);

    public void deletePersonalDataById(String dni);

    public PersonalData convertPersonalDataDTOToEntity(PersonalDataDTO personalDataDTO);

    public PersonalDataDTO convertPersonalDataEntityToDTO(PersonalData personalData);


}
