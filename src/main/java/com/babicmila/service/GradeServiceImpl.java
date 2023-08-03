package com.babicmila.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.babicmila.entity.Course;
import com.babicmila.entity.Grade;
import com.babicmila.entity.Student;
import com.babicmila.exception.EntityNotFoundException;
import com.babicmila.exception.GradeNotFoundException;
import com.babicmila.exception.StudentNotEnrolledException;
import com.babicmila.repository.CourseRepository;
import com.babicmila.repository.GradeRepository;
import com.babicmila.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    GradeRepository gradeRepository;
    StudentRepository studentRepository;
    CourseRepository courseRepository;

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {

        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Student student;

        if (studentOptional.isPresent()) {
            student = studentOptional.get();
            grade.setStudent(student);
        } else {
            throw new EntityNotFoundException(studentId, Student.class);
        }

        Optional<Course> courseOptional = courseRepository.findById(courseId);
        Course course;

        if (courseOptional.isPresent()) {
            course = courseOptional.get();
            grade.setCourse(course);
        } else {
            throw new EntityNotFoundException(courseId, Course.class);
        }

        if (!student.getCourses().contains(course))
            throw new StudentNotEnrolledException(studentId, courseId);

        return gradeRepository.save(grade);
    }

    @Override
    public Grade getGrade(Long studentId, Long courseId) {

        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        if (grade.isPresent()) {
            return grade.get();
        } else {
            throw new GradeNotFoundException(studentId, courseId);
        }

    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {

        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);

        if (grade.isPresent()) {
            Grade updatedGrade = grade.get();
            updatedGrade.setScore(score);
            return gradeRepository.save(updatedGrade);
        } else {
            throw new GradeNotFoundException(studentId, courseId);
        }

    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {

        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }

}
