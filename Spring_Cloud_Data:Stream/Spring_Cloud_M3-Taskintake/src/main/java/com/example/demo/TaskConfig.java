package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TaskConfig {
	
	@Bean
	@Primary
	public TaskProcessor taskprocessor() {
		return new TaskProcessor();
		
	}
}
