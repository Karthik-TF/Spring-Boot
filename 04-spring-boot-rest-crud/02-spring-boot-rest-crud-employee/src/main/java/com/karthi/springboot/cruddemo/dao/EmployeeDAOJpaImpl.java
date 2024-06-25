package com.karthi.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karthi.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
	
	//define field for entity manager
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		super();
		this.entityManager = theEntityManager;
	}



	@Override
	public List<Employee> findAll() {
		// create query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
		//execute the query
		List<Employee> employees = theQuery.getResultList();
		//return the query
		return employees;
	}



	@Override
	public Employee findById(int theId) {
		//get employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		// return employee
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		//save employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		// return employee
		return dbEmployee;
	}



	@Override
	public void deleteById(int theId) {
		// retrieve the employee by id
		Employee theEmployee = entityManager.find(Employee.class, theId);
		//delete the employee
		entityManager.remove(theEmployee);
		
	}
	

}
