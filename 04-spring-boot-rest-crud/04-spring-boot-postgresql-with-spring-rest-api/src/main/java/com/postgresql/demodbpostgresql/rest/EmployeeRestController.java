package com.postgresql.demodbpostgresql.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgresql.demodbpostgresql.Serv.EmployeeService;
import com.postgresql.demodbpostgresql.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	//injection
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		super();
		this.employeeService = theEmployeeService;
	}

	@GetMapping("/employees")
	List<Employee> findAllEmployees(){
		List<Employee> theEmployees = employeeService.findAll();
		return theEmployees;
	}
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		Employee dbEmployee= employeeService.save(theEmployee);
		return dbEmployee;
	}
	

}
