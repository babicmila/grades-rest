package com.babicmila.service;

import java.util.List;
import java.util.Set;

import com.babicmila.entity.Course;
import com.babicmila.entity.Student;

public interface StudentService {
    Student getStudent(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getStudents();
    Set<Course> getEnrolledCourses(Long id);
}