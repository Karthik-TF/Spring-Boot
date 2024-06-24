package com.karthi.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//using postconstruct to load the student data only once..
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("karthi", "suresh"));
		theStudents.add(new Student("charan", "malloth"));
		theStudents.add(new Student("tony", "stark"));
		
	}
	
	//define endpoint for /students
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	//new endpoint for the path variable one to retrieve the student by studentId
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		//check the studentId agains the list size
		if ((studentId >= theStudents.size())||(studentId<0)) {
			throw new StudentNotFoundException("Student id not found -"+studentId);
			
		}
		return theStudents.get(studentId);
	}
	
	//add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		//create a studentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return the Response entity
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);	
		
	}
	//add another exception handler to catch any exception handling ...catch all
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		//create a studentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
				
		//return the Response entity
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
}
