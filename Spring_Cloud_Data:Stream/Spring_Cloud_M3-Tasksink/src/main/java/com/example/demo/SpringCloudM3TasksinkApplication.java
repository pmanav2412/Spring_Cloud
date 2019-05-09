package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class SpringCloudM3TasksinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudM3TasksinkApplication.class, args);
	}

}
