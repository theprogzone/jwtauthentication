package com.theprogzone.jwtauthentication.controller;

import com.theprogzone.jwtauthentication.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api/role") @RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
}
