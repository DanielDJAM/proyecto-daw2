package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.PersonalDataDTO;
import com.danieldjam.ecomer.models.dto.ProductDTO;
import com.danieldjam.ecomer.models.dto.UserDTO;

import java.util.List;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);

    public List<UserDTO> getAllUsers();

    public UserDTO getUserById(String userId);

    public UserDTO updateUser(String userId, UserDTO userDTO);

    public void deleteUserById(String userId);

}
