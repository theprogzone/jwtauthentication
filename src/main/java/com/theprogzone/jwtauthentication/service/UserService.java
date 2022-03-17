package com.theprogzone.jwtauthentication.service;

import com.theprogzone.jwtauthentication.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    void setRoleToUser(String username, String roleCode);
    User findUser(String username);
    List<User> findAllUsers();
}
