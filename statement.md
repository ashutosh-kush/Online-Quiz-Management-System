# Project Statement

## Project Title
Online Quiz Management System

## Problem Statement
Traditional classroom quizzes often require manual distribution, checking, and result calculation. This project provides a simple command-line system through which students can register, attempt quizzes, receive calculated scores, and view their previous results. An administrator can manage the question bank and view submitted results.

## Scope
The project focuses on a small educational quiz environment. It supports student registration, authentication, quiz participation, automatic evaluation, result storage, and administrator question management.

## Target Users

### Students
Students can register, log in, attempt the available quiz, and view their previous scores.

### Administrator
The administrator can add, view, and remove quiz questions and view all stored results.

## High-Level Features

1. Student registration and login
2. Admin authentication
3. Question management
4. Quiz attempt
5. Automatic score calculation
6. Result history
7. File-based storage
8. Input validation

## Java Concepts Used

- Classes and objects
- Encapsulation
- Inheritance
- Polymorphism
- Abstract classes
- Collections
- File I/O
- Exception handling
- Methods and constructors

## Functional Modules

1. User Management
2. Quiz Management
3. Quiz and Result Management

## Non-Functional Requirements

- Performance: common operations should complete quickly for the small classroom dataset.
- Usability: menus and instructions should be clear in the terminal.
- Reliability: valid quiz submissions should produce consistent scores.
- Maintainability: functionality is divided into separate classes.
- Error Handling: invalid numeric input and invalid menu selections are handled.
- Resource Efficiency: the application uses standard Java libraries and simple file storage.

## Limitations

- The application is designed for a classroom demonstration and local command-line use.
- The default administrator credentials are stored in the source for simplicity.
- File-based storage is not intended for large-scale concurrent use.
- The system does not provide a graphical or web interface.

## Future Enhancements

- Multiple quiz categories
- Time-limited quizzes
- Random question selection
- Password hashing
- Database storage
- Leaderboard
- Web or graphical interface
