package com.serviceup.service_marketplace;

import org.springframework.boot.SpringApplication;

public class TestServiceMarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ServiceMarketplaceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
