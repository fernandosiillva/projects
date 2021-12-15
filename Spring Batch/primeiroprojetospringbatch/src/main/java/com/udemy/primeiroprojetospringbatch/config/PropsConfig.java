package com.udemy.primeiroprojetospringbatch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class PropsConfig {

	@Bean
	public PropertySourcesPlaceholderConfigurer config() {
		PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
		config.setLocation(new FileSystemResource("D:/OneDrive/Alura/Java/03 Java para Web/03 Spring Framework/08 Spring Batch/application.properties"));
		return config;
	}
}
