package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@SpringBootApplication
public class SpringCloudM4AuthServerCliApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudM4AuthServerCliApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting cron job");

		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
		resourceDetails.setAccessTokenUri("http://localhost:9000/services/oauth/token");

		resourceDetails.setScope(Arrays.asList("toll_read"));
		resourceDetails.setClientId("pluralsight");
		resourceDetails.setClientSecret("pluralsightsecret");
		resourceDetails.setUsername("manav");
		resourceDetails.setPassword("manavpatel");

		OAuth2RestTemplate templete = new OAuth2RestTemplate(resourceDetails);
		String token = templete.getAccessToken().toString();
		System.out.println("Token " + token);
		String s = templete.getForObject("http://localhost:9001/service/tolldata", String.class);
		System.out.println("result " + s);

	}

}
