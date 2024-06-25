package com.karthi.springboot.cruddemo.rest;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.springboot.cruddemo.dao.EmployeeDAO;
import com.karthi.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeDAO employeeDAO;
	//quick and dirty : inject employee dao(using constructor injection)

	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		super();
		this.employeeDAO = theEmployeeDAO;
	}
	
	//expose "/employees" to return the list of employees
	@GetMapping("/employees")
	public List<Employee>findAll(){
		return employeeDAO.findAll();
	}

}
