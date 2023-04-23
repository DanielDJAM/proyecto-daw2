package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.PersonalDataDTO;
import com.danieldjam.ecomer.models.entities.PersonalData;
import com.danieldjam.ecomer.repository.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonalDataServiceImpl implements PersonalDataService{

    @Autowired
    private PersonalDataRepository personalDataRepository;

    @Override
    public PersonalDataDTO createPersonalData(PersonalDataDTO personalDataDTO) {
        PersonalData personalData = convertPersonalDataDTOToEntity(personalDataDTO);
        PersonalData newPersonalData = personalDataRepository.save(personalData);
        return convertPersonalDataEntityToDTO(newPersonalData);
    }

    @Override
    public List<PersonalDataDTO> getPersonalData() {
        List<PersonalData> personalDataList = personalDataRepository.findAll();
        return personalDataList.stream().map(personalData -> convertPersonalDataEntityToDTO(personalData)).collect(Collectors.toList());
    }

    private PersonalData convertPersonalDataDTOToEntity(PersonalDataDTO personalDataDTO){
        PersonalData personalData = new PersonalData();

        personalData.setDni(personalDataDTO.getDni());
        personalData.setAge(personalDataDTO.getAge());
        personalData.setGenre(personalDataDTO.getGenre());
        personalData.setName(personalDataDTO.getName());
        personalData.setSurname(personalDataDTO.getSurname());

        return personalData;
    };

    private PersonalDataDTO convertPersonalDataEntityToDTO(PersonalData personalData){
        PersonalDataDTO personalDataDTO = new PersonalDataDTO();

        personalDataDTO.setDni(personalData.getDni());
        personalDataDTO.setAge(personalData.getAge());
        personalDataDTO.setGenre(personalData.getGenre());
        personalDataDTO.setName(personalData.getName());
        personalDataDTO.setSurname(personalData.getSurname());

        return personalDataDTO;
    };

}
