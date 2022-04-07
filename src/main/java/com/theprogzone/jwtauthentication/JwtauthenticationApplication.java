package com.theprogzone.jwtauthentication;

import com.theprogzone.jwtauthentication.domain.Role;
import com.theprogzone.jwtauthentication.domain.User;
import com.theprogzone.jwtauthentication.service.RoleService;
import com.theprogzone.jwtauthentication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class JwtauthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtauthenticationApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService, RoleService roleService) {
		return args -> {
			roleService.saveRole(new Role(null, "USER"));
			roleService.saveRole(new Role(null, "MANAGER"));
			roleService.saveRole(new Role(null, "ADMIN"));
			roleService.saveRole(new Role(null, "SUPER_ADMIN"));

			userService.saveUser(new User(null, "Test1", "User1", "testuser1", "abc123", new ArrayList<>()));
			userService.saveUser(new User(null, "Test2", "User2", "testuser2", "abc123", new ArrayList<>()));
			userService.saveUser(new User(null, "Test3", "User3", "testuser3", "abc123", new ArrayList<>()));
			userService.saveUser(new User(null, "Test4", "User4", "testuser4", "abc123", new ArrayList<>()));

			userService.setRoleToUser("testuser2", "USER");
			userService.setRoleToUser("testuser2", "MANAGER");
			userService.setRoleToUser("testuser1", "USER");
			userService.setRoleToUser("testuser3", "MANAGER");
			userService.setRoleToUser("testuser4", "MANAGER");
			userService.setRoleToUser("testuser4", "ADMIN");
			userService.setRoleToUser("testuser4", "SUPER_ADMIN");
		};
	}
}
