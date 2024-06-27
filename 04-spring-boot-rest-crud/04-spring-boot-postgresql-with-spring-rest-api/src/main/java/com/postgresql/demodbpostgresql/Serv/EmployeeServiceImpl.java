package com.postgresql.demodbpostgresql.Serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresql.demodbpostgresql.entity.Employee;
import com.postgresql.demodbpostgresql.jparepository.EmployeeJpaRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	//field
	private EmployeeJpaRepository employeeJpaRepository;
	
	//injection
	@Autowired
	public EmployeeServiceImpl(EmployeeJpaRepository theEmployeeJpaRepository) {
		super();
		this.employeeJpaRepository = theEmployeeJpaRepository;
	}
	@Override
	public List<Employee> findAll() {
		List<Employee> theEmployees = employeeJpaRepository.findAll();
		return theEmployees;
	}
	@Override
	public Employee save(Employee theEmployee) {
		Employee dbEmployee = employeeJpaRepository.save(theEmployee);
		return dbEmployee;
	}

	

}
