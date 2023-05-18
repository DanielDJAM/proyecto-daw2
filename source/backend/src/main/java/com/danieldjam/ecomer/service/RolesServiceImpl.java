package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.ProductDTO;
import com.danieldjam.ecomer.models.dto.RolesDTO;
import com.danieldjam.ecomer.models.entities.Roles;
import com.danieldjam.ecomer.models.entities.User;
import com.danieldjam.ecomer.repository.RolesRepository;
import com.danieldjam.ecomer.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolesServiceImpl implements RolesService{

    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public RolesDTO createRol(RolesDTO rolesDTO) {
        Roles roles = new Roles();
        mapDtoToEntity(rolesDTO, roles);
        Roles newRol = rolesRepository.save(roles);
        return mapEntityToDto(newRol);
    }

    @Override
    public List<RolesDTO> getAllRoles() {
        List<RolesDTO> rolesDTOList = new ArrayList<>();
        List<Roles> rolesList = rolesRepository.findAll();
        rolesList.stream().forEach(role -> {
            RolesDTO rolesDTO = mapEntityToDto(role);
            rolesDTOList.add(rolesDTO);
        });
        return rolesDTOList;
    }

    @Override
    public RolesDTO getRolByName(String name) {
        Roles rol = rolesRepository.findByName(name);
        return mapEntityToDto(rol);
    }

    @Override
    public RolesDTO getRolById(String rolId) {
        Roles rol = rolesRepository.findById(Integer.parseInt(rolId)).get();
        return mapEntityToDto(rol);
    }

    @Transactional
    @Override
    public RolesDTO updateRol(String rolId, RolesDTO rolesDTO) {
        Roles roles = rolesRepository.getOne(Integer.parseInt(rolId));
        roles.getUserList().clear();
        mapDtoToEntity(rolesDTO, roles);
        return mapEntityToDto(rolesRepository.save(roles));
    }

    @Transactional
    @Override
    public void deleteRol(String rolId) {
        Roles roles = rolesRepository.findById(Integer.parseInt(rolId)).get();
        roles.removeAllUsers();
        rolesRepository.deleteById(roles.getRolId());
    }

    private void mapDtoToEntity(RolesDTO rolesDTO, Roles roles){
        roles.setName(rolesDTO.getName());
        roles.setDescription(rolesDTO.getDescription());
        if (null == roles.getUserList()){
            roles.setUserList(new ArrayList<>());
        }
        rolesDTO.getUserList().stream().forEach(userId -> {
            User user = userRepository.findByUserId(userId.toString());
            if (null == user){
                user = new User();
                user.setRolesList(new ArrayList<>());
            }
            user.setUserId(userId);
            roles.addUser(user);
        });
    }

    private RolesDTO mapEntityToDto(Roles roles){
        RolesDTO rolesDTO = new RolesDTO();
        rolesDTO.setRolId(roles.getRolId());
        rolesDTO.setName(roles.getName());
        rolesDTO.setDescription(roles.getName());
        rolesDTO.setUserList(roles.getUserList().stream().map(User::getUserId).collect(Collectors.toList()));
        return rolesDTO;
    }


}
