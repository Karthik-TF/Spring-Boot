package com.karthi.springboot.cruddemo.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.springboot.cruddemo.entity.Employee;
import com.karthi.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeService employeeService;
	//constructor injection)
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		super();
		this.employeeService = theEmployeeService;
	}
	
	//expose "/employees" to return the list of employees
	@GetMapping("/employees")
	public List<Employee>findAll(){
		return employeeService.findAll();
	}
	
	// mapping "/employee/{empployeeId}" for single employee
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int  employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		return theEmployee;
	}
	

}
