package com.theprogzone.jwtauthentication.service;

import com.theprogzone.jwtauthentication.domain.Role;
import com.theprogzone.jwtauthentication.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {}", role.getCode());
        return roleRepository.save(role);
    }
}
