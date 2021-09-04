package com.ellie.restdemo;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}

}

class Coffee {
	
	private final String id;
	private String name;
	
	public Coffee(String id, String name) {
		this.id=id;
		this.setName(name);
	}
	
	public Coffee(String name) {
		
		this(UUID.randomUUID().toString(), name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
}