package com.joshua.springboot.controller;

import com.joshua.springboot.entity.User;
import com.joshua.springboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/addPerson")
    public String createUser(@RequestBody User user) {
        return service.addUser(user.getName(),user.getSurname());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.removeUser(id);
    }

    @GetMapping("/GetById/{id}")
    public String readUser(@PathVariable int id) {
        return service.getUser(id);
    }

}
