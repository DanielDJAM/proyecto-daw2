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

    @Override
    public PersonalData convertPersonalDataDTOToEntity(PersonalDataDTO personalDataDTO){
        return modelMapper.map(personalDataDTO, PersonalData.class);
    }

    @Override
    public PersonalDataDTO convertPersonalDataEntityToDTO(PersonalData personalData){
        return modelMapper.map(personalData, PersonalDataDTO.class);
    }



}
