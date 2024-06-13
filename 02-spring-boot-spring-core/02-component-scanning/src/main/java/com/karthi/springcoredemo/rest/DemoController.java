package com.karthi.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.springcoredemo.common.Coach;

@RestController

public class DemoController {

	//private field for the dependency
	private Coach myCoach;
	//define constructor for dependency injection
	@Autowired
	public DemoController(Coach theCoach) {
		myCoach = theCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
}
