package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.AddressDTO;
import com.danieldjam.ecomer.models.dto.PersonalDataDTO;
import com.danieldjam.ecomer.models.entities.Address;
import com.danieldjam.ecomer.models.entities.PersonalData;
import com.danieldjam.ecomer.repository.PersonalDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PersonalDataServiceImpl implements PersonalDataService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PersonalDataRepository personalDataRepository;

    @Autowired
    private AddressService addressService;

    @Override
    public List<PersonalDataDTO> getAllPersonalData() {
        List<PersonalData> personalDataList = personalDataRepository.findAll();
        return personalDataList.stream().map(personalData -> convertPersonalDataEntityToDTO(personalData)).collect(Collectors.toList());
    }

    @Override
    public PersonalDataDTO getPersonalDataById(String dni) {
        PersonalData personalData = personalDataRepository.findById(dni)
                .orElseThrow(() -> new NoSuchElementException("Personal Data not found with dni " + dni));
        return convertPersonalDataEntityToDTO(personalData);
    }

    @Override
    public PersonalDataDTO createPersonalData(PersonalDataDTO personalDataDTO) {
        return convertPersonalDataEntityToDTO(personalDataRepository.save(convertPersonalDataDTOToEntity(personalDataDTO)));
    }

    @Override
    public PersonalDataDTO updatePersonalData(String dni, PersonalDataDTO personalDataDTO) {
        PersonalData personalData = personalDataRepository.findById(dni)
                .orElseThrow(() -> new NoSuchElementException("Personal Data not found with dni " + dni));
        personalData.setName(personalDataDTO.getName());
        personalData.setBirthdate(personalDataDTO.getBirthdate());
        personalData.setGenre(personalDataDTO.getGenre());
        personalData.setSurname(personalDataDTO.getSurname());
        PersonalData updatedPersonalData = personalDataRepository.save(personalData);
        return convertPersonalDataEntityToDTO(updatedPersonalData);
    }

    @Override
    public void deletePersonalDataById(String dni) {
        personalDataRepository.deleteById(dni);
    }

    public PersonalData convertPersonalDataDTOToEntity(PersonalDataDTO personalDataDTO){
        return modelMapper.map(personalDataDTO, PersonalData.class);
    }

    public PersonalDataDTO convertPersonalDataEntityToDTO(PersonalData personalData){
        return modelMapper.map(personalData, PersonalDataDTO.class);
    }



}
