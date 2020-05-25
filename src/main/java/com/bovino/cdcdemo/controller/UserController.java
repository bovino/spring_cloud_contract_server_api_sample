package com.bovino.cdcdemo.controller;

import com.bovino.cdcdemo.domain.User;
import com.bovino.cdcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User saveNewUser(@RequestBody User user){
        return userService.saveNewUser(user);
    }

    @DeleteMapping("/user")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer[] ids){
        return userService.deleteUser(ids);
    }
}
