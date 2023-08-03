package com.babicmila.service;

import java.util.List;
import java.util.Set;

import com.babicmila.entity.Course;
import com.babicmila.entity.Student;

public interface CourseService {
    
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();
    Course addStudentToCourse(Long courseId, Long studentId);
    Set<Student> getEnrolledStudents(Long id);
}