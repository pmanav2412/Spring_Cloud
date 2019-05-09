package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringCloudM3TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudM3TaskApplication.class, args);
	}
	
	@Bean
	public tollProcesstask TollProcessingTask() {
		return new tollProcesstask();
	}
	
	public class tollProcesstask implements CommandLineRunner{

		@Override
		public void run(String... strings) throws Exception {
			if(null != strings) {
				System.out.println("parameter length : "+ strings.length +"  bcx "  );
				
				String stationId = strings[0];
				String licencePlate = strings[1];
				String timestamp = strings[2];
				System.out.println(stationId  + "  123 "  + licencePlate + " 456 " + timestamp);
			}
			
		}
		
	}

}
