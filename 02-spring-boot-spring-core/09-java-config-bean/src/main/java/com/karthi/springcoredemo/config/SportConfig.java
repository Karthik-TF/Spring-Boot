package com.karthi.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.karthi.springcoredemo.common.Coach;
import com.karthi.springcoredemo.common.SwimCoach;

@Configuration
public class SportConfig {
	@Bean("bruce")
	public Coach swimCoach() {
		return new SwimCoach();
	}

}
