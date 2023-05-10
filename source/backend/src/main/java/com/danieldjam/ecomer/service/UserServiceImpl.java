package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.UserDTO;
import com.danieldjam.ecomer.models.entities.*;
import com.danieldjam.ecomer.repository.RolesRepository;
import com.danieldjam.ecomer.repository.UserRepository;
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

    @Autowired
    private RolesRepository rolesRepository;

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
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with userId " + userId));
        return convertUserEntityToDTO(user);
    }

    @Override
    public UserDTO updateUser(String userId, UserDTO userDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with userId " + userId));
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return convertUserEntityToDTO(userRepository.save(user));
    }

    @Override
    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }

    private UserDTO convertUserEntityToDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    };

    private User convertUserDTOToEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    };
}
