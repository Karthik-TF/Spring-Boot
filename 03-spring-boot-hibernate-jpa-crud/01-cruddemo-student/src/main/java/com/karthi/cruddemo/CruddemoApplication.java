package com.karthi.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.karthi.cruddemo.dao.StudentDAO;
import com.karthi.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		//create student object 
		System.out.println("Creating new Student object...");
		Student tempStudent = new Student("karthik","s","karthi@123.com");
		
		//save student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		//display id of saved student obj
		System.out.println("saved student. Generated id: "+ tempStudent.getId());
		
	}

	
	
	
}
