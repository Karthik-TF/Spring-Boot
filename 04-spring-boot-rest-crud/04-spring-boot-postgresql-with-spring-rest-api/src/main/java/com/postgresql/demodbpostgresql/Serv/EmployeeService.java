package com.postgresql.demodbpostgresql.Serv;

import java.util.List;

import com.postgresql.demodbpostgresql.entity.Employee;
public interface EmployeeService {
	List<Employee> findAll();
	Employee save(Employee theEmployee);
}
