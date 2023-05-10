package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.RolesDTO;
import com.danieldjam.ecomer.models.entities.Roles;
import com.danieldjam.ecomer.repository.RolesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RolesServiceImpl implements RolesService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public RolesDTO createRol(RolesDTO rolesDTO) {
        Roles newRol = rolesRepository.save(convertRolesDTOToEntity(rolesDTO));
        return convertRolesEntityToDTO(newRol);
    }

    @Override
    public List<RolesDTO> getAllRoles() {
        List<Roles> rolesList = rolesRepository.findAll();
        return rolesList.stream().map(roles -> convertRolesEntityToDTO(roles)).collect(Collectors.toList());
    }

    @Override
    public RolesDTO getRolById(String id) {
        Roles rol = rolesRepository.findByName(id)
                .orElseThrow(() -> new NoSuchElementException("Rol not found with rolId " + id));
        return convertRolesEntityToDTO(rol);
    }

    @Override
    public RolesDTO updateRol(String id, RolesDTO rolesDTO) {
        Roles rol = rolesRepository.findByName(id)
                .orElseThrow(() -> new NoSuchElementException("Rol not found with rolId " + id));
        rol.setName(rolesDTO.getName());
        rol.setDescription(rolesDTO.getDescription());
        Roles rolUpdate = rolesRepository.save(rol);
        return convertRolesEntityToDTO(rolUpdate);
    }

    @Override
    public void deleteRol(String id) { rolesRepository.deleteById(id); }

    public RolesDTO convertRolesEntityToDTO(Roles roles) {
        return modelMapper.map(roles, RolesDTO.class);
    }

    public Roles convertRolesDTOToEntity(RolesDTO rolesDTO){
        return modelMapper.map(rolesDTO, Roles.class);
    }
}
