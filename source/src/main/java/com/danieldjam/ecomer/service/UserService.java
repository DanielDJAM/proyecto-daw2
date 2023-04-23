package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.UserDTO;

import java.util.List;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);

    public List<UserDTO> getUsers();

}
