package com.springcourse.cruddemo.dao;

import com.springcourse.cruddemo.entity.Instructor;
import com.springcourse.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    void update(Instructor instructor);

    InstructorDetail findInstructorDetailById(int id);

}
