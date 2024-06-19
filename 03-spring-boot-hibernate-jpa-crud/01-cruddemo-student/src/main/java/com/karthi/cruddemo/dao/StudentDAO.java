package com.karthi.cruddemo.dao;

import com.karthi.cruddemo.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	
	Student findById(Integer id);

}
