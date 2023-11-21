package br.edu.infnet.appsell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AppsellApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppsellApplication.class, args);
	}

}
