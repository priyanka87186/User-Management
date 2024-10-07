package com.usersmanagementsystem.app;

import com.usersmanagementsystem.app.entity.Users;
import com.usersmanagementsystem.app.enums.Role;
import com.usersmanagementsystem.app.repository.UsersRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.usersmanagementsystem.app.enums.Role.ADMIN;

@SpringBootApplication
public class UsersmanagementsystemApplication {

	@Autowired
	private UsersRepo usersRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(UsersmanagementsystemApplication.class, args);
		UsersmanagementsystemApplication application = context.getBean(UsersmanagementsystemApplication.class);
		application.createDefaultAdmin();
	}

	@PostConstruct
	public void createDefaultAdmin() {
		// Checking if an admin user already exists
		boolean adminExists = usersRepository.existsByRole(ADMIN);

		// This method is creating the default admin user so there will never be more than one ADMIN in the system and this can modified as per the requirements
		if (!adminExists) {
			// Creating the default admin user
			Users adminUser = new Users();
			adminUser.setEmail("admin@example.com");
			adminUser.setName("Admin");
			adminUser.setPassword(passwordEncoder.encode("admin123"));  // Default admin password (should be changed)
			adminUser.setCity("DefaultCity");
			adminUser.setRole(ADMIN);

			// Save the default admin to the database
			usersRepository.save(adminUser);
			System.out.println("Default admin user created: admin@example.com");
		} else {
			System.out.println("Admin user already exists. No new admin created.");
		}
	}

}
