package com.zh.zipkinclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZipkinClientApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZipkinClientApplication.class, args);
	}
}
