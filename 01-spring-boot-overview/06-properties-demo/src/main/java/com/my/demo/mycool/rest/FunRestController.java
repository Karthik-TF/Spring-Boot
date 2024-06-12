package com.my.demo.mycool.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FunRestController {
	
	//inject custom properties for: coach.name and team.name
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	// EXposing endpoints  for the teaminfo which using the custom properties
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach:" +coachName+", Team name: "+teamName;
	}
	
	
	
	// exposing endpoints
	@GetMapping("/")
	public String sayHello() {
		return "Hello World!";
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "run a hard 5k!";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is Your Lucky day";
	}

}