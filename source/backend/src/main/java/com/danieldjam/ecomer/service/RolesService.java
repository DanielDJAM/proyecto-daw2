package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.RolesDTO;
import com.danieldjam.ecomer.models.entities.Roles;

import java.util.List;

public interface RolesService {

    public RolesDTO createRol(RolesDTO rolesDTO);
    public List<RolesDTO> getAllRoles();
    public RolesDTO getRolById(String id);
    public RolesDTO updateRol(String id, RolesDTO rolesDTO);
    public void deleteRol(String id);
    public RolesDTO convertRolesEntityToDTO(Roles roles);
    public Roles convertRolesDTOToEntity(RolesDTO rolesDTO);

}
