# REST API for Grades Management System

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)

## Overview

The Grades Management System REST API is used for managing course grades in an educational setting. This API allows users to perform CRUD (Create, Read, Update, Delete) operations on students, grades, courses, and related data. Each HTTP request triggers an accurate HTTP response code.
  
- Utilized JSON Web Token (JWT) as a primary security component, ensuring secure access to endpoints by validating and authorizing incoming requests. Applying an HMAC-SHA512 hash algorithm with a secret key to ensure 99% integrity and authenticity of the token.

- Designed Exception handling for specific Exception types, contributing to an 80% decrease in generic error messages and providing more informative responses.

- Integrated a MySQL Database for data management using Docker Compose, for enhancement of scalability, providing portable environment, and simplifying collaboration.

## Getting Started

### Prerequisites

- Java 17
- Apache Maven
- Docker for MySQL database

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/babicmila/grades-rest.git
   cd grades-rest

2. Install dependencies:

   ```bash
   mvn clean install
   docker compose build

3. Run the application
   ```bash
   docker compose run
   mvn spring-boot:run

The API will be accessible at http://localhost:8080 by default. For testing endpoints use Postman.

## API Documentation

### Endpoints
1. Get All Students

   Endpoint: GET /student/all    
 
   Description: Retrieve a list of all students.

  ```bash
    GET localhost:8080/student/all
  ```

2. Get Student by ID

    Endpoint: GET /student/{id}
   
    Description: Retrieve information about a specific student.

  ```bash
    GET localhost:8080/student/2
  ```

3. Add New Course

    Endpoint: POST /course

    Description: Add a new course to the system.

   ```bash
   POST localhost:8080/course
   {
    "subject": "OOP",
    "code": "CS102",
    "description": "Object-oriented Programming in Java"
   }
   ```

4. Update Grade

     Endpoint: PUT /grade/student/{id}/course/{id}

     Description: Update information for a specific grade.

   ```bash
   PUT localhost:8080/grade/student/1/course/1

   {
    "score": "B+"
   }
   ```

5. Delete Grade

     Endpoint: DELETE /grade/student/{id}/course/{id}

     Description: Delete a specific grade from the system.

   ```bash
   DELETE localhost:8080/grade/student/4/course/1
   ```

