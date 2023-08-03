package com.babicmila.exception;

public class StudentNotEnrolledException extends RuntimeException {

    public StudentNotEnrolledException(Long studentId, Long courseId) {
        super("Student with id " + studentId + " is not enrolled in course with id "
                + courseId + " !");
    }

}
