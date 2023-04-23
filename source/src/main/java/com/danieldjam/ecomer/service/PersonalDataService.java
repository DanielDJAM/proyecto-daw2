package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.PersonalDataDTO;
import java.util.List;

public interface PersonalDataService {

    public PersonalDataDTO createPersonalData(PersonalDataDTO personalDataDTO);

    public List<PersonalDataDTO> getPersonalData();


}
