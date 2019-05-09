package com.example.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@SpringBootApplication
@RestController
@EnableResourceServer
public class SpringCloudM3TaskSecureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudM3TaskSecureServiceApplication.class, args);
	}
	
	@RequestMapping("/tolldata")
	public List<TollUsage> getTolldata(){
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		List<TollUsage> list = new ArrayList<>();
		list.add(new TollUsage("101", "1", "QWERTY", "2016-09-30T06:31:12"));
		list.add(new TollUsage("102", "2", "SGUITY", "2016-09-30T07:41:13"));
		list.add(new TollUsage("103", "3", "QNIHOY", "2016-09-30T09:38:32"));
		
		for(TollUsage a:list)
			System.out.println(a);
		return list;
	}
	
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	 public class TollUsage implements Serializable {
		


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
