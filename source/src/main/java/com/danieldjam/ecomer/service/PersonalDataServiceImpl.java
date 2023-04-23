package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.AddressDTO;
import com.danieldjam.ecomer.models.dto.PersonalDataDTO;
import com.danieldjam.ecomer.models.entities.Address;
import com.danieldjam.ecomer.models.entities.PersonalData;
import com.danieldjam.ecomer.repository.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PersonalDataServiceImpl implements PersonalDataService{

    @Autowired
    private PersonalDataRepository personalDataRepository;

    @Autowired
    private AddressService addressService;

//    @Override
//    public PersonalDataDTO createPersonalData(PersonalDataDTO personalDataDTO) {
//        PersonalData personalData = convertPersonalDataDTOToEntity(personalDataDTO);
//        PersonalData newPersonalData = personalDataRepository.save(personalData);
//        return convertPersonalDataEntityToDTO(newPersonalData);
//    }

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
        PersonalData personalData = convertPersonalDataDTOToEntity(personalDataDTO);
        PersonalData savedPersonalData = personalDataRepository.save(personalData);
        return convertPersonalDataEntityToDTO(savedPersonalData);
    }

    @Override
    public PersonalDataDTO updatePersonalData(String dni, PersonalDataDTO personalDataDTO) {
        PersonalData personalData = personalDataRepository.findById(dni)
                .orElseThrow(() -> new NoSuchElementException("Personal Data not found with dni " + dni));
        personalData.setName(personalDataDTO.getName());
        personalData.setAddressId(addressService.convertAddressDTOToEntity(personalDataDTO.getAddressId()));
        PersonalData updatedPersonalData = personalDataRepository.save(personalData);
        return convertPersonalDataEntityToDTO(updatedPersonalData);
    }

    @Override
    public void deletePersonalDataById(String dni) {
        personalDataRepository.deleteById(dni);
    }


    private PersonalData convertPersonalDataDTOToEntity(PersonalDataDTO personalDataDTO){
        PersonalData personalData = new PersonalData();

        personalData.setDni(personalDataDTO.getDni());
        personalData.setAddressId(addressService.convertAddressDTOToEntity(personalDataDTO.getAddressId()));
        personalData.setAge(personalDataDTO.getAge());
        personalData.setGenre(personalDataDTO.getGenre());
        personalData.setName(personalDataDTO.getName());
        personalData.setSurname(personalDataDTO.getSurname());

        return personalData;
    }

    private PersonalDataDTO convertPersonalDataEntityToDTO(PersonalData personalData){
        PersonalDataDTO personalDataDTO = new PersonalDataDTO();

        personalDataDTO.setDni(personalData.getDni());
        personalDataDTO.setAddressId(addressService.convertAddressEntityToDTO(personalData.getAddressId()));
        personalDataDTO.setAge(personalData.getAge());
        personalDataDTO.setGenre(personalData.getGenre());
        personalDataDTO.setName(personalData.getName());
        personalDataDTO.setSurname(personalData.getSurname());

        return personalDataDTO;
    }



}
