package com.outfit7.AdMediation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AdMediationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdMediationApplication.class, args);
	}

}
