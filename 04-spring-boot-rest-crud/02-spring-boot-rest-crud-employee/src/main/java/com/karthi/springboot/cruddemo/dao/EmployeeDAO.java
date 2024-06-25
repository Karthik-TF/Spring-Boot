package com.karthi.springboot.cruddemo.dao;

import java.util.List;

import com.karthi.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	List<Employee> findAll();

}
