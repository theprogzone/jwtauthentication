package com.theprogzone.jwtauthentication.service;

import com.theprogzone.jwtauthentication.domain.Role;
import com.theprogzone.jwtauthentication.domain.User;
import com.theprogzone.jwtauthentication.repository.RoleRepository;
import com.theprogzone.jwtauthentication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {}", user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public void setRoleToUser(String username, String roleCode) {
        log.info("Set role {} to the user {}", roleCode, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByCode(roleCode);
        user.getRoles().add(role);
    }

    @Override
    public User findUser(String username) {
        log.info("Finding user {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        log.info("Finding all users");
        return userRepository.findAll();
    }
}
