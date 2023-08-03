package com.babicmila.repository;

import org.springframework.data.repository.CrudRepository;

import com.babicmila.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
    
}