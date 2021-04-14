package com.webappsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.webappsecurity.security.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class AppSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSecurityJpaApplication.class, args);
	}

}
