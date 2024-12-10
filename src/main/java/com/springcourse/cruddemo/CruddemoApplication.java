package com.springcourse.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springcourse.cruddemo.entity.Course;
import com.springcourse.cruddemo.entity.Instructor;
import com.springcourse.cruddemo.service.InstructorService;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorService instructorService) {

		return runner -> {

			// instructorService.createInstructor(new Instructor("John", "Doe",
			// "dd@gmail.com"));

			// instructorService.findCoursesForInstructor(1);

			// instructorService.saveCourseAndReviews(new Course("Java Masterclass"));
			// instructorService.findCourseAndReviewsByCourseId(10);

			// instructorService.deleteCourseAndReviews(10);

			instructorService.createCourseAndStudents("Java Masterclass");

		};
	}

}