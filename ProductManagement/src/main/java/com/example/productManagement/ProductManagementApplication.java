package com.example.productManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.productManagement.Entities.Product;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class ProductManagementApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration rC;

	
	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		rC.exposeIdsFor(Product.class);
	}

	/*@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"ones","123",true,null));

	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("admin", "USER");
	userService.addRoleToUser("ones", "USER");
	
	}
	@Bean
	BCryptPasswordEncoder getBCE() {
	return new BCryptPasswordEncoder();
	}*/
}
