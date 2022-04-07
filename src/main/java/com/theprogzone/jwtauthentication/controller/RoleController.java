package com.theprogzone.jwtauthentication.controller;

import com.theprogzone.jwtauthentication.domain.Role;
import com.theprogzone.jwtauthentication.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api/role") @RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.saveRole(role), HttpStatus.CREATED);
    }
}
