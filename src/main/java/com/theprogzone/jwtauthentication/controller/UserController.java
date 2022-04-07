package com.theprogzone.jwtauthentication.controller;

import com.theprogzone.jwtauthentication.domain.User;
import com.theprogzone.jwtauthentication.dto.RoleToUserDTO;
import com.theprogzone.jwtauthentication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController @RequestMapping("/api/user") @RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/add-to-user")
    public ResponseEntity<?> setRoleToUser(@RequestBody RoleToUserDTO roleToUserDTO) {
        userService.setRoleToUser(roleToUserDTO.getUsername(), roleToUserDTO.getRoleCode());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
