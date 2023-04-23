package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.UserDTO;
import com.danieldjam.ecomer.models.entities.*;
import com.danieldjam.ecomer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServicesImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = convertUserDTOToEntity(userDTO);
        User newUser = userRepository.save(user);
        return convertUserEntityToDTO(newUser);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(user -> convertUserEntityToDTO(user)).collect(Collectors.toList());
    }

    private UserDTO convertUserEntityToDTO(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    };

    private User convertUserDTOToEntity(UserDTO userDTO){
        User user = new User();
        PersonalData dni = new PersonalData();
        Order order = new Order();
        Rol rol = new Rol();
        Product product = new Product();
        DetailInvoice detailInvoice = new DetailInvoice();

        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setDni(dni);
        user.setCreateTime(new Date());
        //user.setOrders(order);
        //user.setRols(rol);
        //user.setProducts(product);
        //user.setDetailInvoices(detailInvoice);
        return user;
    };
}
