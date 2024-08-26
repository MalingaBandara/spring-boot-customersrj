
# Spring Boot Customer Registration System

## Project Overview

This project is a RESTful API developed using Spring Boot, designed to handle customer registration and management. The API provides full CRUD functionality along with security measures like token-based authentication and role-based access control. The project showcases my ability to build secure and scalable backend applications using Java and Spring Boot.

## Key Features

- Secure token-based authentication using JWT.
- Customer management with full CRUD operations.
- Role-based access control for enhanced security.
- Swagger integration for API documentation.
- MySQL database integration for persistent data storage.
- Exception handling and logging for better error tracking.

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Token)**
- **MySQL**
- **Swagger**
- **Maven**

## Project Structure and Code Explanation

1. **Entity Classes**:
   - Represent the customer and role entities mapped to the database.
   - Annotations like `@Entity`, `@Table`, and `@Column` handle the mapping.

2. **Service Layer**:
   - Contains business logic for handling customer operations and security implementations.
   - Example:
   ```java
   @Service
   public class CustomerService {
       // Business logic for customer operations
   }
   ```

3. **Controller Layer**:
   - Exposes RESTful endpoints to manage customers and handle authentication.
   - Example:
   ```java
   @RestController
   @RequestMapping("/api/customers")
   public class CustomerController {
       // API endpoints for customer management
   }
   ```

4. **Security Configuration**:
   - Implements Spring Security and JWT for securing API endpoints.

## Commits and Project Evolution

1. **Initial Setup**: Created project structure and configured Spring Boot dependencies.
2. **Customer Management**: Added CRUD operations for customer management.
3. **Security Implementation**: Integrated JWT-based authentication and role management.

## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/MalingaBandara/spring-boot-customersrj.git
   ```
2. Import the project into your preferred IDE.
3. Configure the database connection in `application.properties`.
4. Run the application using:
   ```bash
   mvn spring-boot:run
   ```

## Purpose and Future Enhancements

This project serves as a demonstration of my backend development skills, particularly in building secure and scalable applications. Future enhancements may include adding more complex features like OAuth2 integration, multi-tenancy, and detailed analytics.

## POS UI
 [UI Repository Link](https://github.com/MalingaBandara/pos-ui-Spring-boot)

## UI Screenshots

 <img src="https://github.com/MalingaBandara/spring-boot-customersrj/blob/master/UI.png" height="50%" >


## License

This project is licensed under the MIT License.
