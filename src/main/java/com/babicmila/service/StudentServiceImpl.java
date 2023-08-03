package com.babicmila.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.babicmila.entity.Course;
import com.babicmila.entity.Student;
import com.babicmila.exception.EntityNotFoundException;
import com.babicmila.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {

        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {
            return student.get();
        } else {
            throw new EntityNotFoundException(id, Student.class);
        }
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Set<Course> getEnrolledCourses(Long studentId) {
      
        Student student = getStudent(studentId);
        return student.getCourses();
    }

}