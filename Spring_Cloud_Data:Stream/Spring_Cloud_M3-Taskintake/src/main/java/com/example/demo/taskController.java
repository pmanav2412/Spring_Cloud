package com.example.demo;

import java.lang.invoke.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.client.impl.Method;

@RestController
public class taskController {

	@Autowired
	private TaskProcessor t;
	
	@RequestMapping(path="/tasks", method=RequestMethod.POST)
	public @ResponseBody String launchTask(@RequestBody String s) {
		t.pulishrequest(s);
		System.out.println("request mode!");
		return "success";
	}
	
	
}
