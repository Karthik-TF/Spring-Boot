package com.karthi.springboot.cruddemo.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.springboot.cruddemo.entity.Employee;
import com.karthi.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
	
	//post mapping for add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		//also just in case if they pass id in JSON set it to 0
		//this is to force to save a new item instead of update
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	//put mapping for updating an already exist employee in db
	@PutMapping("/employees")
	public Employee updatEmployee(@RequestBody Employee theEmployee) {
		//i implemented the following to restrict saving a new employee 
		int rowId = theEmployee.getId();
		Employee db2Employee = employeeService.findById(rowId);
		if(db2Employee==null) {
			throw new RuntimeException("Employee id not found - "+rowId);
		}
		//updating a employee
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	//Delete mapping for "/employees/{employeeId}"
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployees(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		employeeService.deleteById(employeeId);
		return "Deleted employee id - "+employeeId;
	}

	
	
	
	
}
