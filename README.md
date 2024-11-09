# Spring Boot CRUD Application for Beginners

This project is a beginner-friendly Spring Boot application demonstrating basic CRUD (Create, Read, Update, Delete) operations. It combines several technologies—Spring Boot, Thymeleaf, HTML, and Bootstrap—to provide a simple web interface for managing data. The application is designed as a learning resource for developers new to Spring Boot, helping them get familiar with its fundamentals and web development with Thymeleaf.

## Features

- **CRUD Operations**: Full support for Create, Read, Update, and Delete operations.
- **Spring Boot Framework**: Leverages Spring Boot for building and running the application easily.
- **Thymeleaf Integration**: Uses Thymeleaf as the view engine to dynamically render HTML pages.
- **Bootstrap for Styling**: Includes Bootstrap to style forms, tables, and other UI components.
- **MySQL Database**: Persistent storage of data using MySQL, a widely-used relational database.

## Technologies Used

- **Spring Boot** - Core framework for building the application.
- **Spring Data JPA** - For database access and CRUD operations.
- **Thymeleaf** - View layer for rendering HTML with Spring Boot.
- **Bootstrap** - CSS framework for responsive design.
- **MySQL** - Relational database for data persistence.

## Getting Started

### Prerequisites

- **Java 8+** - Ensure Java is installed on your machine.
- **Maven** - Used for building and managing project dependencies.
- **MySQL Database** - Set up MySQL on your system and create a database for this application.

**Project Structure** :
**Controllers**: Handles incoming requests and routes them to appropriate views or services.
**Services**: Business logic for handling CRUD operations.
**Repositories**: Data access layer, interacting with the MySQL database.
**Templates**: Thymeleaf templates for the web interface.
**Static Resources**: CSS, JavaScript, and Bootstrap assets.

**Usage** :
The application provides a basic user interface to:

.Create new records
.View a list of records
.Update existing records
.Delete records

**Configure Database**:

spring.datasource.url=jdbc:mysql://localhost:3306/sbcrud
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

**Build and Run the Application**

mvn spring-boot:run

**Access the Application**

Visit http://localhost:8080 in your web browser to start using the app.


**Contribution**

Contributions are welcome! Feel free to fork the repository and submit a pull request.
