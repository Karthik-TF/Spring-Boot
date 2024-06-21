package com.karthi.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	//define endpoint for /students
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> theStudents = new ArrayList<>();
		
		theStudents.add(new Student("karthi", "suresh"));
		theStudents.add(new Student("charan", "malloth"));
		theStudents.add(new Student("tony", "stark"));
		
		return theStudents;
	}

}
