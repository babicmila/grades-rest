package com.babicmila.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.babicmila.entity.Course;
import com.babicmila.entity.Student;
import com.babicmila.exception.EntityNotFoundException;
import com.babicmila.repository.CourseRepository;
import com.babicmila.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;
    StudentRepository studentRepository;

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourse(Long id) {

        Optional<Course> course = courseRepository.findById(id);

        if (course.isPresent()) {
            return course.get();
        } else {
            throw new EntityNotFoundException(id, Course.class);
        }
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course addStudentToCourse(Long courseId, Long studentId) {

        Course course = getCourse(courseId);
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        Student student;

        if (studentOptional.isPresent()) {

            student = studentOptional.get();

        } else {
            throw new EntityNotFoundException(studentId, Student.class);
        }

        course.getStudents().add(student);

        return courseRepository.save(course);
    }

    @Override
    public Set<Student> getEnrolledStudents(Long courseId) {

        Course course = getCourse(courseId);
        return course.getStudents();
    }

}
