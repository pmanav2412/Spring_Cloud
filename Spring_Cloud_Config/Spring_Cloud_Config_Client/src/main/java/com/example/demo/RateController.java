package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RefreshScope
public class RateController {

	
	@Value("${rate}")
	String rate;
	
	@Value("${lanecount}")
	String lanecount;
	
	@Value("${tollstart}")
	String ts;
	
	@Value("${connString}")
	String cS;
	
	@RequestMapping(value="/Hello")
	public String getConfig(Model model) {
		
		model.addAttribute("rate", rate);
		model.addAttribute("lanecount", lanecount);
		model.addAttribute("tollstart", ts);
		model.addAttribute("connString", cS);
		
		return "Config";
	}
}
