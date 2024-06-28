package com.postgresql.demodbpostgresql.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.postgresql.demodbpostgresql.entity.Employee;
//@RepositoryRestResource(path="members")
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>{
	//
}

