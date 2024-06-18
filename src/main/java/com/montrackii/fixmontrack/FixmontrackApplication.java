package com.montrackii.fixmontrack;

import com.montrackii.fixmontrack.config.RsaKeyConfigProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyConfigProperty.class)
@SpringBootApplication
public class FixmontrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FixmontrackApplication.class, args);
	}

}
