package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.UserDTO;
import com.danieldjam.ecomer.models.entities.*;
import com.danieldjam.ecomer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserServicesImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonalDataService personalDataService;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = convertUserDTOToEntity(userDTO);
        User newUser = userRepository.save(user);
        return convertUserEntityToDTO(newUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(user -> convertUserEntityToDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with userId " + userId));
        return convertUserEntityToDTO(user);
    }

    @Override
    public UserDTO updateUser(String userId, UserDTO userDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Personal Data not found with userId " + userId));
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        User updatedUser = userRepository.save(user);
        return convertUserEntityToDTO(updatedUser);
    }

    @Override
    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }

    private UserDTO convertUserEntityToDTO(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(user.getUserId());
        userDTO.setDni(personalDataService.convertPersonalDataEntityToDTO(user.getDni()));
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    };

    private User convertUserDTOToEntity(UserDTO userDTO){
        User user = new User();

        user.setUserId(userDTO.getUserId());
        user.setDni(personalDataService.convertPersonalDataDTOToEntity(userDTO.getDni()));
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        return user;
    };
}
