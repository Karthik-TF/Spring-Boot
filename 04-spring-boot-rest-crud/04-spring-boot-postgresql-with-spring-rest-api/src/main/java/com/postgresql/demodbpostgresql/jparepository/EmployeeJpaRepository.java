package com.postgresql.demodbpostgresql.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.postgresql.demodbpostgresql.entity.Employee;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>{
	//
}

