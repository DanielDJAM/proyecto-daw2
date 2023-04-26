package com.danieldjam.ecomer.controllers;

import com.danieldjam.ecomer.models.dto.UserDTO;
import com.danieldjam.ecomer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String userId) { return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);}

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable String userId, @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.updateUser(userId, userDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

}
