package com.karthi.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karthi.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;



@Repository
public class StudentDAOImpl implements StudentDAO{
	
	//define field for entity manager
	private EntityManager entityManager;
	
	//inject entity manager using cons inj
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	//implement save method

	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
		// TODO Auto-generated method stub
		
	}

	

}
