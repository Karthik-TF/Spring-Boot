package com.karthi.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthi.springboot.cruddemo.dao.EmployeeRepository;
import com.karthi.springboot.cruddemo.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	//cons injection
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		super();
		this.employeeRepository = theEmployeeRepository;
	}
	

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Did not find the employee id -"+ theId);
		}
		return theEmployee;
	}


	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theId);
		
	}

}
