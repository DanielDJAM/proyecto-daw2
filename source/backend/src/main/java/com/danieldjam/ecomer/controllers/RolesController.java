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

    @GetMapping("/{id}")
    public ResponseEntity<RolesDTO> getRolById(@PathVariable String id) {
        return new ResponseEntity<>(rolesService.getRolById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolesDTO> editRolById(@PathVariable String id, @RequestBody RolesDTO rolesDTO) {
        return new ResponseEntity<>(rolesService.updateRol(id, rolesDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRolById(@PathVariable String id){
        rolesService.deleteRol(id);
        return ResponseEntity.noContent().build();
    }

}
