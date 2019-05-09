package com.example.demo;

import java.io.Serializable;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Controller
@EnableOAuth2Sso
public class ApplicationController extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private OAuth2ClientContext clientContext;
	
	@Autowired
	private OAuth2RestTemplate oauth2resttemplate;
	
	
	@RequestMapping("/")
	public String Hello() {
		return "home";
	}
	
	@RequestMapping("/reports")
	public String loadReport(Model model) {
		OAuth2AccessToken t = clientContext.getAccessToken();
		System.out.println("token : " + t.getValue());
		
		ResponseEntity<ArrayList<TollUsage>> toll  = oauth2resttemplate.exchange("http://localhost:9001/service/tolldata", HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<TollUsage>>() {
		});
		
		model.addAttribute("tolls",toll.getBody());
		
		return "reports";
	}

	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.authorizeRequests()
		.antMatchers("/","home")
		.permitAll()
		.anyRequest()
		.authenticated();
	}
	
	@SuppressWarnings("serial")
	@JsonIgnoreProperties(ignoreUnknown = true)
	 public static class TollUsage implements Serializable {
		


		 String Id;
		 String stationId;
		 String licenseplate;
		 String timestamp;
		 
		 public TollUsage() {
			 
		 }

		public TollUsage(String iD, String stationId, String licenseplate, String timestamp) {
			super();
			Id = iD;
			this.stationId = stationId;
			this.licenseplate = licenseplate;
			this.timestamp = timestamp;
		}

		public String getId() {
			return Id;
		}

		public void setId(String id) {
			Id = id;
		}

		public String getStationId() {
			return stationId;
		}

		public void setStationId(String stationId) {
			this.stationId = stationId;
		}

		public String getLicenseplate() {
			return licenseplate;
		}

		public void setLicenseplate(String licenseplate) {
			this.licenseplate = licenseplate;
		}

		public String getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		 
		 
	}

	

}
