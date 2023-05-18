package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.PersonalDataDTO;
import com.danieldjam.ecomer.models.dto.UserDTO;
import com.danieldjam.ecomer.models.entities.*;
import com.danieldjam.ecomer.repository.PersonalDataRepository;
import com.danieldjam.ecomer.repository.RolesRepository;
import com.danieldjam.ecomer.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User newUser = userRepository.save(convertUserDTOToEntity(userDTO));
        return convertUserEntityToDTO(newUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(user -> convertUserEntityToDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(String userId) {
        User user = userRepository.findById(Integer.parseInt(userId))
                .orElseThrow(() -> new NoSuchElementException("User not found with userId " + userId));
        return convertUserEntityToDTO(user);
    }

    @Override
    public UserDTO updateUser(String userId, UserDTO userDTO) {
        User user = userRepository.findById(Integer.parseInt(userId))
                .orElseThrow(() -> new NoSuchElementException("User not found with userId " + userId));
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return convertUserEntityToDTO(userRepository.save(user));
    }

    @Override
    public void deleteUserById(String userId) {
        userRepository.deleteById(Integer.parseInt(userId));
    }

    private UserDTO convertUserEntityToDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    };

    private User convertUserDTOToEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    };

//
//    private PersonalDataDTO convertPersonalDataEntityToDTO(PersonalData personalData){return modelMapper.map(personalData, PersonalDataDTO.class);}
//
//    private PersonalData convertPersonalDataDtoToEntity(PersonalDataDTO personalDataDTO){return modelMapper.map(personalDataDTO, PersonalData.class);}
//
//    private void mapDtoToEntity(UserDTO userDTO, User user){
//        user.setDni(convertPersonalDataDtoToEntity(userDTO.getDni()));
//        user.setUsername(userDTO.getUsername());
//        user.setPassword(userDTO.getPassword());
//        user.setEmail(userDTO.getEmail());
//        user.setOrderList(userDTO.getOrderList());
//    }


}
