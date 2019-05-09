package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class TaskProcessor {
	
	@Autowired
	private Source source;
	
	
	public void pulishrequest(String payload) {
		String url = "maven://com.example:Spring_Cloud_M3_Task:jar:0.0.1-SNAPSHOT";
		
		List<String> input = new ArrayList<String>(Arrays.asList(payload.split(",")));
		TaskLaunchRequest req = new TaskLaunchRequest(url, input, null, null, null);
		System.out.println("created atsk req.");
		
		GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(req);
		this.source.output().send(message);
	}
	

}
