package com.babicmila.repository;

import org.springframework.data.repository.CrudRepository;

import com.babicmila.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}