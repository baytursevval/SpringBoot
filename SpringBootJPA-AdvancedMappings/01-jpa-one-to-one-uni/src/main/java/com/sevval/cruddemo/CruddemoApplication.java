package com.sevval.cruddemo;

import com.sevval.cruddemo.dao.AppDAO;
import com.sevval.cruddemo.entity.Instructor;
import com.sevval.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) { //executed after the spring beans have been loaded

		return runner -> {
			//System.out.println("hello world");
				//createInstructor(appDAO);

			//findInstructor(appDAO);

			deleteInstructor(appDAO);
			};
		}

	private void deleteInstructor(AppDAO appDAO) {

		int id=1;
		System.out.println("deleting instructor id:"+id);
		appDAO.deleteInstructorById(id);

		System.out.println("done.");
	}

	private void findInstructor(AppDAO appDAO) {

		int id=1;
		System.out.println("finding instructor id:" + id);

		Instructor tempInstructor=appDAO.findInstructorById(id);

		System.out.println("instructor:" + tempInstructor);
		System.out.println("details: "+ tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		/*
		Instructor tempInstructor =
				new Instructor("chad", "darby", "chad@demomail.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://youtube.com", "codding");
*/
		Instructor tempInstructor =
				new Instructor("medhu", "patel", "chad@demomail.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://youtube.com", "guitar");
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("saving instructor:" + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("done..");
	}
	}


