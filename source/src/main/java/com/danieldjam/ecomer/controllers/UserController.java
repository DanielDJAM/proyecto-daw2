package com.danieldjam.ecomer.controllers;

import com.danieldjam.ecomer.dao.UserDao;
import com.danieldjam.ecomer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    /* @RequestMapping(value = "usuario/{uid}")
    public User getUsuario(@PathVariable String uid){
        User usuario = new User();
        return "prueba";
    }

    @RequestMapping(value = "login")
    public User login(){
        User usuario = new User();
        return "prueba";
    }

    @RequestMapping(value = "register")
    public User insert(){
        User usuario = new User();
        return "prueba";
    }

    @RequestMapping(value = "prueba")
    public User edit(){
        User usuario = new User();
        return "prueba";
    }*/

    @RequestMapping(value = "prueba")
    public String remove(){
        return "prueba";
    } 

    @RequestMapping(value = "userList")
    public List<User> getUserList(){
        return userDao.getUserList();
    }



}
