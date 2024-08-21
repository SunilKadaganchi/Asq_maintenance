package dev.sunil.Asq.maintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AsqMaintenanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsqMaintenanceApplication.class, args);
	}

}
