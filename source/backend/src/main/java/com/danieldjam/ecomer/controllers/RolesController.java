package com.danieldjam.ecomer.controllers;

import com.danieldjam.ecomer.models.dto.RolesDTO;
import com.danieldjam.ecomer.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    RolesService rolesService;

    @GetMapping
    public List<RolesDTO> getRoles(){ return rolesService.getAllRoles();}

    @PostMapping
    public ResponseEntity<RolesDTO> createRol(@RequestBody RolesDTO rolesDTO) {
        return new ResponseEntity<>(rolesService.createRol(rolesDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{rolId}")
    public ResponseEntity<RolesDTO> getRolById(@PathVariable String rolId) {
        return new ResponseEntity<>(rolesService.getRolById(rolId), HttpStatus.OK);
    }

    @PutMapping("/{rolId}")
    public ResponseEntity<RolesDTO> editRolById(@PathVariable String rolId, @RequestBody RolesDTO rolesDTO) {
        return new ResponseEntity<>(rolesService.updateRol(rolId, rolesDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{rolId}")
    public ResponseEntity<Void> deleteRolById(@PathVariable String rolId){
        rolesService.deleteRol(rolId);
        return ResponseEntity.noContent().build();
    }

}
