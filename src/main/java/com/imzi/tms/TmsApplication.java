package com.imzi.tms;

import com.imzi.tms.authentication.model.Role;
import com.imzi.tms.authentication.model.User;
import com.imzi.tms.authentication.service.RoleService;
import com.imzi.tms.authentication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;

@SpringBootApplication
@ComponentScan(basePackages = "com.imzi.tms.authentication")
public class TmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmsApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService, RoleService roleService){
		return args -> {
			boolean run = false;
			if (run){
				roleService.save(new Role(null, "ROLE_USER"));
				roleService.save(new Role(null, "ROLE_ADMIN"));

				userService.save(new User(null, "Abbas Imthath", "amimthath@gmail.com", "abc123", new ArrayList<>()));
				userService.save(new User(null, "Fathima Mahroof", "fathimamahroof1994@gmail.com", "abc123", new ArrayList<>()));

				userService.addRoleToUser("amimthath@gmail.com", "ROLE_USER");
				userService.addRoleToUser("fathimamahroof1994@gmail.com", "ROLE_ADMIN");

			}
		};
	}
}
