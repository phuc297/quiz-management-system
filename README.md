
# Quiz Management System

## Overview
This project is a Java-based application designed to manage and conduct multiple-choice quizzes. The system allows administrators to create and manage quizzes, while users (students) can take quizzes and view their results. The application is built using **Java Swing** for the graphical user interface (GUI) and **MySQL** as the database for storing data.

## Key Features
- **Question Management**: Add, edit, delete, and categorize questions by topics.
- **Quiz Management**: Create quizzes from a question bank and set time limits for each quiz.
- **User Management**: Manage user roles (administrators and students).
- **Quiz Taking**: Students can log in and take quizzes through an intuitive GUI.
- **Automatic Grading**: The system automatically grades quizzes and displays results immediately.
- **Report Generation**: Generate reports of quiz results by student or quiz.

## Technologies Used
- **Java Swing**: For building the graphical user interface.
- **MySQL**: For storing and managing data such as users, questions, and quiz results.
- **Apache Ant**: For building and running the project.

## Prerequisites
- **Java Development Kit (JDK)** 8 or higher
- **MySQL Server** (with a configured database for the application)
- **Apache Ant** (for building the project)
- **NetBeans IDE** (optional, for development)

## Setup Instructions
1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd <repository-folder>
   ```

2. Set up the MySQL database:
   - Import the provided SQL script (if available) to create the necessary tables and data.
   - Update the `sqlConnectString.txt` file with your MySQL connection details.

3. Ensure the required libraries are present in the `lib/` directory.

## Screenshots from project
<img src="https://github.com/user-attachments/assets/f69ba9c0-7a62-4450-9a32-d633b13a1642" width="600">

<img src="https://github.com/user-attachments/assets/06d9ea2e-c125-4bb2-9d61-8aa57a505f94" width="600">
