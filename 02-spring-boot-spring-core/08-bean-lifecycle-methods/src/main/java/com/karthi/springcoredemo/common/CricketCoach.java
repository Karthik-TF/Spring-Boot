package com.karthi.springcoredemo.common;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach {
	
	public CricketCoach() {
		System.out.println("In Constructor: " + getClass().getSimpleName());
	}
	
	//define init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("In doMyStartupStuff(): "+ getClass().getSimpleName());
	}
	//define destroy method
	@PreDestroy
	public void doCleanupStuff() {
		System.out.println("In doCleanupStuff(): "+ getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutues!!!";
	}

	
	
}
