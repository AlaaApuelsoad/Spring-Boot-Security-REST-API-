# Secured Spring Boot Application with MySQL and JPA

This guide helps you set up a secured Spring Boot application with role-based access control, MySQL, JPA, and Spring Security.

## Step 1: Create a Spring Boot Project Using Spring Initializr

1. **Go to Spring Initializr**:
   - Navigate to [Spring Initializr](https://start.spring.io/).

2. **Project Configuration**:
   - **Project Type**: Maven Project
   - **Language**: Java
   - **Spring Boot Version**: 3.3.2
   - **Packaging**: Jar
   - **Java Version**: 17

3. **Dependencies**:
   - Spring Web
   - Spring Data JPA
   - MySQL Driver
   - Lombok
   - Spring Security

---

## Step 2: Configure `application.properties`

1. Set your application name, database connection, and other properties in the `src/main/resources/application.properties` file.
   - **Project name**: Set `spring.application.name=security`.
   - **Database connection**: Configure the database URL, username, and password.
   - **JPA configuration**: Enable Hibernate auto-update for schema and SQL logging.

# Application Name 
spring.application.name=security

spring.main.banner-mode=off

# Servlet Path
server.servlet.context-path=/api

# Database connection properties
spring.datasource.url=jdbc:mysql://localhost:3306/spring_security_test?createDatabaseIfNotExist=true

spring.datasource.username=springstudent

spring.datasource.password=springstudent

# JPA and Hibernate properties
spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true

---

## Step 3: Create Entity Classes

1. **Create a Package**:
   - Create a new package named `model` for your entity classes.

2. **Create Entity Classes**:
   - Define entities such as `Product` , `Order` , `User` , `Role` with the appropriate annotations for mapping to database tables.

---

## Step 4: Create Repository Interfaces

1. **Create a Package**:
   - Create a new package named `repository`.

2. **Define Repository Interfaces**:
   - For each entity (e.g., `Product`, `Order`, `User`, `Role`), create a corresponding repository interface that extends `JpaRepository`.

---

## Step 5: Create Service Classes

1. **Create a Package**:
   - Create a new package named `service`.

2. **Implement Business Logic**:
   - In the service package, create service classes for handling CRUD operations and business logic for the entities.

---

## Step 6: Implement Security Configuration

1. **Enable Web Security**:
   - Create a security configuration class annotated with `@EnableWebSecurity`.

2. **Role-Based Access Control**:
   - Define role-based access control for different endpoints.
   - Configure Spring Security to restrict access to specific roles (e.g., `admin`, `customer`).

---

## Step 7: Add Initialization Logic

1. **Create Application Initialization Logic**:
   - Implement a service to initialize roles and create default admin users when the application starts.
   - Use `@PostConstruct` to ensure roles are created on startup.

---

## Step 8: Test and Run

1. **Start the Application**:
   - Run the Spring Boot application.
   - The necessary database tables will be created automatically, and default roles and users will be initialized.

2. **Test Role-Based Access**:
   - Use tools like Postman or cURL to test secured and public API endpoints.
   - Ensure proper authentication and authorization based on roles.
   
---

## Step 9: Setup Instructions

1. **MySQL Database Setup**:
   - Ensure MySQL is installed and running on your machine.
   - Create a new database, or let Spring Boot create it automatically by enabling the `createDatabaseIfNotExist=true` option in the datasource URL.

2. **Run the Application**:
   - Execute `mvn spring-boot:run` or run the main class from your IDE to start the Spring Boot application.

3. **Verify**:
   - Test the APIs to ensure role-based security is applied correctly and CRUD operations work as expected.
