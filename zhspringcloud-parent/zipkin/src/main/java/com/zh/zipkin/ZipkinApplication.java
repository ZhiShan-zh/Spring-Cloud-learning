package com.zh.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableZipkinServer
public class ZipkinApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZipkinApplication.class, args);
	}
}
