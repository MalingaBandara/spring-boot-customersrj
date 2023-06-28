package com.bitlord.pos;

import com.bitlord.pos.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PosApplication implements CommandLineRunner {


	// User Service
	@Autowired
	private UserRoleService userRoleService;


	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}


	// this method like Init method ( run this method when program running )
	@Override
	public void run(String... args) throws Exception {
		userRoleService.initializeRoles(); // crete and save users
	}


}
