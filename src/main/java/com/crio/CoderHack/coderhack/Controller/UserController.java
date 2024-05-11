package com.crio.CoderHack.coderhack.Controller;


import com.crio.CoderHack.coderhack.DTO.UserRequestDTO;
import com.crio.CoderHack.coderhack.DTO.UserResponseDTO;
import com.crio.CoderHack.coderhack.Model.User;
import com.crio.CoderHack.coderhack.Service.UserService;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET /users - Retrieve a list of all registered users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // GET /users/{userId} - Retrieve the details of a specific user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable BigInteger userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST /users - Register a new user to the contest
    @PostMapping
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO user) {
        UserResponseDTO newUser = userService.registerUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // PUT /users/{userId} - Update the score of a specific user
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateScore(@PathVariable BigInteger userId, @RequestBody User user) {
        User updatedUser = userService.updateScore(userId, user.getScore());
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE /users/{userId} - Deregister a specific user from the contest
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deregisterUser(@PathVariable BigInteger userId) {
        boolean deleted = userService.deregisterUser(userId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

