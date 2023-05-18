package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.RolesDTO;
import com.danieldjam.ecomer.models.entities.Roles;

import java.util.List;

public interface RolesService {

    public RolesDTO createRol(RolesDTO rolesDTO);
    public List<RolesDTO> getAllRoles();
    public RolesDTO getRolByName(String name);
    public RolesDTO getRolById(String id);
    public RolesDTO updateRol(String name, RolesDTO rolesDTO);
    public void deleteRol(String id);

}
