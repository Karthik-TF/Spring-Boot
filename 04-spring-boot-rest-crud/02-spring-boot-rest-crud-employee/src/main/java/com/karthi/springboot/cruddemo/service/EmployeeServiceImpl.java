package com.karthi.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthi.springboot.cruddemo.dao.EmployeeDAO;
import com.karthi.springboot.cruddemo.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	//cons injection
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		super();
		this.employeeDAO = theEmployeeDAO;
	}
	

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}

}
