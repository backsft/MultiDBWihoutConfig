package com.MultiDBWithoutConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MultiDbWithoutConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiDbWithoutConfigApplication.class, args);
	}

}
