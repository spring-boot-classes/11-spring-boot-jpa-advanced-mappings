package com.springcourse.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springcourse.cruddemo.dao.AppDAO;
import com.springcourse.cruddemo.entity.InstructorDetail;
import com.springcourse.cruddemo.entity.Instructor;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);
		};
	};

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Chad2", "Darby2", "cf2@gmail.com");

		InstructorDetail instructiorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");

		instructor.setInstructiorDetail(instructiorDetail);

		appDAO.save(instructor);

	}

}
