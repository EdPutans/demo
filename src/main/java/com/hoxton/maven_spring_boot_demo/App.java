package com.hoxton.maven_spring_boot_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 1. Add @SpringBootApplication to the entry point in App.java
@SpringBootApplication
public class App {

	public static void main(String[] args) {
    // 2. Replace the default with SpringApplication initiator:
		SpringApplication.run(App.class, args);
	}
}
