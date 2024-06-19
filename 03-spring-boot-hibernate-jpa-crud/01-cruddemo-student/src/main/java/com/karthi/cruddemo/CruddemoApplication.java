package com.karthi.cruddemo;

import org.hibernate.event.spi.SaveOrUpdateEvent;
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
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}
	

	private void readStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		//create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("karl", "jacob", "karl@123.com");
		
		//save the student object
		System.out.println("Saving the student object...");
		studentDAO.save(tempStudent);
		
		//display the saved student id
		int theId= tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);
		
		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id:  "+theId);
		Student myStudent = studentDAO.findById(theId);
		
		//display student
		System.out.println("Found the student: "+myStudent);
		
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		//create obj
		System.out.println("Creating new Student object...");
		Student tempStudent1 = new Student("shiba","s","shiba@123.com");
		Student tempStudent2 = new Student("jaga","T","jaga@123.com");
		Student tempStudent3 = new Student("charan","m,","charan@123.com");
		
		//Save them
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		//display id's
		System.out.println("saved student. Generated id: "+ tempStudent1.getId());
		System.out.println("saved student. Generated id: "+ tempStudent2.getId());
		System.out.println("saved student. Generated id: "+ tempStudent3.getId());
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
