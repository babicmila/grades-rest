REST API for Grades Management System

- Implemented HTTP Methods with URL endpoints supporting CRUD operations with grades, students, courses, etc. Additionally, endpoints are available for retrieving the entire entity lists. Each HTTP request triggers an accurate HTTP response code.
  
- Utilized JSON Web Token (JWT) as a primary security component, ensuring secure access to endpoints by validating and authorizing incoming requests. Applying an HMAC512 hash algorithm with a secret key to ensure a 98% integrity guarantee and authenticity of the token.

- Designed Exception handling for specific Exception types, contributing to an 80% decrease in generic error messages and providing more informative responses.

- Integrated a MySQL Database for data management using Docker Compose, for enhancement of scalability, providing portable environment, and simplifying collaboration.

Postman HTTP Requests:

![HTTP Requests](https://github.com/babicmila/grades-rest/assets/57596723/290dcc81-492a-45bb-852c-8d5cd0933b24)

Database Design:

![Database design](https://github.com/babicmila/grades-rest/assets/57596723/78bc44a3-4887-46f1-98f3-7f51496abedd)
