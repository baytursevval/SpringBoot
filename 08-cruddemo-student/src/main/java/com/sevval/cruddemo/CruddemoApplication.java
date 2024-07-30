package com.sevval.cruddemo;

import com.sevval.cruddemo.dao.StudentDAO;
import com.sevval.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			//System.out.println("hello world");
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudent(studentDAO);

			//queryForStudentByName(studentDAO);

			//updateStudent(studentDAO);

			deleteStudent(studentDAO);

			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("deleting all students");
		int numRowDeleted=studentDAO.deleteAll();
		System.out.println("deleted row count:" + numRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId=6;
		System.out.println("deleting student with id: "+ studentId);

		studentDAO.delete(studentId);


	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("getting student with id: "+ studentId);

		Student myStudent=studentDAO.findById(studentId);

		System.out.println("updating student..");
		myStudent.setFirstName("scooby");


		studentDAO.update(myStudent);

		System.out.println("updated student "+ myStudent);
	}

	private void queryForStudentByName(StudentDAO studentDAO) {

		List<Student> theStudent=studentDAO.findByName("mrv");

		for (Student tempStudent: theStudent){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {

		List<Student> theStudents=studentDAO.findAll();

		for (Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("new student:");
		Student tempStudent= new Student("sevvallll", "tezel","fdfds@gmail.com");

		System.out.println("saving the student..");
		studentDAO.save(tempStudent);

		int Id=tempStudent.getId();
		System.out.println("saved student. generated id: "+ Id);

		System.out.println("retrieving student. generated id: "+ Id);
		Student myStudent=studentDAO.findById(Id);

		System.out.println("found the student: " +myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("new 3 students:");
		Student tempStudent1= new Student("mst", "tezel","fdfds@gmail.com");
		Student tempStudent2= new Student("mrv", "erkt","fdfds@gmail.com");
		Student tempStudent3= new Student("suki", "akdnz","fdfds@gmail.com");

		System.out.println("saving the students..");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("new student:");
		Student tempStudent= new Student("sevval", "tezel","fdfds@gmail.com");

		System.out.println("saving the student..");
		studentDAO.save(tempStudent);

		System.out.println("saved student. generated id: "+ tempStudent.getId());

	}
}
