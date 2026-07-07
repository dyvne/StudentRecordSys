# Smart Student Record Management System

## Overview

The Smart Student Record Management System is a JavaFX desktop application developed using Java and Object-Oriented Programming (OOP) principles. It provides an intuitive graphical interface for managing student information through a complete set of Create, Read, Update, and Delete (CRUD) operations.

The application is designed with a layered architecture that separates the user interface, business logic, and data model, making the system easier to maintain and extend.

## Features

* Administrator login
* Student registration
* View all student records
* Search students by ID
* Update student information
* Delete student records
* Dashboard with summary information
* JavaFX graphical user interface

## Technologies Used

* Java
* JavaFX
* Maven
* IntelliJ IDEA
* Git and GitHub
* Object-Oriented Programming (OOP)

## System Architecture

The application follows a layered architecture consisting of:

* **Model Layer** – Represents application data through the `Student` class.
* **Service Layer** – Implements business logic using classes such as `StudentManager` and `LoginManager`.
* **View Layer** – Provides the JavaFX user interface, including the login screen, dashboard, student form, and student table.
* **Application Layer** – Initializes and launches the application.

## Installation and Execution

### Prerequisites

* Java JDK 17 or later
* Maven
* IntelliJ IDEA (recommended)

### Running the Application

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Allow Maven to download all required dependencies.
4. Run the `Main` class or execute:

```bash
mvn javafx:run
```

## Testing

Core system functionality has been tested, including:

* User authentication
* Student registration
* Student search
* Student record updates
* Student deletion
* Dashboard functionality

Detailed test results are available in `TESTING.md`.

## Challenges Encountered

The primary challenges during development included configuring JavaFX with Maven, resolving module path issues, and integrating the user interface with the application's business logic. These challenges were addressed through proper dependency management and a modular application design.

## Future Enhancements

Potential future improvements include:

* Database integration
* Role-based user management
* Export of student records to PDF or Excel
* Student photo management
* Report generation
* Data backup and recovery

## Developer

**Divine Kwame Mawudoku**

MSc Information Technology
University of Cape Coast, Ghana

**Year:** 2026

## License

This project was developed for academic purposes as part of the MSc Information Technology programme at the University of Cape Coast.
