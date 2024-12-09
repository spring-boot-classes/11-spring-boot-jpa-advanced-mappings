package com.springcourse.cruddemo.dao;

import java.util.List;

import com.springcourse.cruddemo.entity.Course;
import com.springcourse.cruddemo.entity.Instructor;
import com.springcourse.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    void update(Instructor instructor);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

}
