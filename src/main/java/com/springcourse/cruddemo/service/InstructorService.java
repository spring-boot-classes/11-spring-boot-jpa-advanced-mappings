package com.springcourse.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.cruddemo.dao.AppDAO;
import com.springcourse.cruddemo.entity.Course;
import com.springcourse.cruddemo.entity.Instructor;
import com.springcourse.cruddemo.entity.InstructorDetail;
import com.springcourse.cruddemo.entity.Review;

@Service
public class InstructorService {
    public final AppDAO appDAO;

    @Autowired
    public InstructorService(AppDAO appDAO) {
        this.appDAO = appDAO;
    }

    public void deleteCourse(int theId) {

        // delete course
        appDAO.deleteCourseById(theId);

        System.out.println("Done!");
    }

    public void updateCourse(int theId) {

        // get course from db
        Course tempCourse = appDAO.findCourseById(theId);

        // update course
        tempCourse.setTitle("Java Masterclass");

        // save the course
        appDAO.update(tempCourse);

        System.out.println("Done!");
    }

    public void updateInstructor(int theId) {

        // get instructor from db
        Instructor tempInstructor = appDAO.findById(theId);

        // update instructor
        tempInstructor.setFirstName("Scoobggddd");

        // save the instructor
        appDAO.update(tempInstructor);

        System.out.println("Done!");
    }

    public void findInstructorWithCoursesJoinFetch(int theId) {

        // find the instructor
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    public void findCoursesForInstructor(int theId) {

        // find instructor
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findById(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        // find courses for instructor
        System.out.println("Finding courses for instructor id: " + theId);
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);

        // associate the objects
        tempInstructor.setCourses(courses);

        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    public void findInstructorWithCourses(int theId) {

        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    public void createInstructorWithCourses(Instructor tempInstructor) {

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "http://www.youtube.com",
                "Video Games");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // create some courses
        Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
        Course tempCourse2 = new Course("The Pinball Masterclass");

        // add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        //
        // NOTE: this will ALSO save the courses
        // because of CascadeType.PERSIST
        //
        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    public void deleteInstructorDetail(int theId) {

        System.out.println("Deleting instructor detail id: " + theId);

        appDAO.deleteInstructorDetailById(theId);

        System.out.println("Done!");
    }

    public void findInstructorDetail(int theId) {

        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

        // print the instructor detail
        System.out.println("tempInstructorDetail: " + tempInstructorDetail);

        // print the associated instructor
        System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

        System.out.println("Done!");
    }

    public void deleteInstructor(int theId) {

        System.out.println("Deleting instructor id: " + theId);

        appDAO.deleteById(theId);

        System.out.println("Done!");
    }

    public void findInstructor(int theId) {
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());

    }

    public void createInstructor(Instructor tempInstructor) {

        /*
         * // create the instructor
         * Instructor tempInstructor =
         * new Instructor("Chad", "Darby", "darby@luv2code.com");
         * 
         * // create the instructor detail
         * InstructorDetail tempInstructorDetail =
         * new InstructorDetail(
         * "http://www.luv2code.com/youtube",
         * "Luv 2 code!!!");
         */

        // create the instructor

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "http://www.luv2code.com/youtube",
                "Guitar");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        //
        // NOTE: this will ALSO save the details object
        // because of CascadeType.ALL
        //
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    public void saveCourseAndReviews(Course tempCourse) {

        // add some reviews
        tempCourse.addReview(new Review("Great course ... loved it!"));
        tempCourse.addReview(new Review("Cool course, job well done"));
        tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

        // save the course ... and leverage the cascade all :-)
        System.out.println("Saving course: " + tempCourse);
        System.out.println("Reviews: " + tempCourse.getReviews());
        appDAO.save(tempCourse);

        System.out.println("Done!");
    }

    public void findCourseAndReviewsByCourseId(int theId) {

        Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

        System.out.println("tempCourse: " + tempCourse);
        System.out.println("Reviews: " + tempCourse.getReviews());

        System.out.println("Done!");
    }

    public void deleteCourseAndReviews(int theId) {

        // get the course
        Course tempCourse = appDAO.findCourseById(theId);

        // delete the course
        appDAO.deleteCourseById(theId);

        System.out.println("Done!");
    }
}
