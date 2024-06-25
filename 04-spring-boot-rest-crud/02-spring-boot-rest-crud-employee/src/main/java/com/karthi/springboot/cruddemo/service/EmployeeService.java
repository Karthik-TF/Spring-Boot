package com.karthi.springboot.cruddemo.service;

import java.util.List;

import com.karthi.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();

}
