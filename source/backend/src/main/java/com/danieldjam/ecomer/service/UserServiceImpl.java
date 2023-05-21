package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.UserDTO;
import com.danieldjam.ecomer.models.entities.*;
import com.danieldjam.ecomer.repository.PersonalDataRepository;
import com.danieldjam.ecomer.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder passwordEncoder;

    @Autowired
    PersonalDataRepository personalDataRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = convertUserDTOToEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return convertUserEntityToDTO(userRepository.save(user));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(user -> mapEntityToDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(String userId) {
        User user = userRepository.findById(Integer.parseInt(userId))
                .orElseThrow(() -> new NoSuchElementException("User not found with userId " + userId));
        return mapEntityToDto(user);
    }

    @Override
    public UserDTO updateUser(String userId, UserDTO userDTO) {
        User user = userRepository.findById(Integer.parseInt(userId))
                .orElseThrow(() -> new NoSuchElementException("User not found with userId " + userId));
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
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

    private void mapDtoToEntity(UserDTO userDTO, User user){
        user.setDni(personalDataRepository.getReferenceById(userDTO.getDni()));
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
    }

    private UserDTO mapEntityToDto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setDni(user.getDni().getDni());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setProductList(user.getProductList().stream().map(Product::getProductId).collect(Collectors.toList()));
        userDTO.setOrderList(user.getOrderList().stream().map(Order::getOrderId).collect(Collectors.toList()));
        return userDTO;
    }



}
