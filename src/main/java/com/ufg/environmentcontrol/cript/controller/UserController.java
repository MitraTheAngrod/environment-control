package com.ufg.environmentcontrol.cript.controller;

import com.ufg.environmentcontrol.cript.model.UserModel;
import com.ufg.environmentcontrol.cript.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Identifies that it's a controller
// Maps the controller page
@RestController
@RequestMapping("/api/user")
public class UserController {

    // Autowired is used to use only one instance of UserRepository as a bin instead of making multiple instances and consuming more resources
    @Autowired
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserController(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    // Lists all users on the database
    @GetMapping("/listAll")
    public ResponseEntity<List<UserModel>> listAllUsers() {
        return ResponseEntity.ok(repository.findAll());
    }

    // Encrypts the password and save the user on the database
    @PostMapping("/save")
    public ResponseEntity<UserModel> save(@RequestBody UserModel user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return ResponseEntity.ok(repository.save(user));
    }
}
