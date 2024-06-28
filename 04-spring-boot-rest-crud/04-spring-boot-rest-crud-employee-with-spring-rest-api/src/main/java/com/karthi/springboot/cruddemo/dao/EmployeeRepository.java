package com.karthi.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthi.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	//Automagic
}
