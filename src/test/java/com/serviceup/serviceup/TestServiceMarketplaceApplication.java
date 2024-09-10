package com.serviceup.serviceup;

import org.springframework.boot.SpringApplication;

public class TestServiceMarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ServiceUpApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
