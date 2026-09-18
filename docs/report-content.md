# Project Report Content

## 1. Introduction
The Online Quiz Management System is a Java command-line application developed to simplify basic quiz administration. It provides separate student and administrator functions and stores application data in local files.

## 2. Problem Statement
Manual quiz management requires effort for question distribution, checking answers, calculating scores, and maintaining result records. The proposed system automates these basic activities in a simple terminal-based environment.

## 3. Objectives
- Provide student registration and authentication.
- Allow students to attempt a quiz.
- Calculate scores automatically.
- Store and display results.
- Allow an administrator to manage questions.
- Demonstrate core Java programming concepts.

## 4. Functional Requirements
Use the three modules documented in statement.md.

## 5. Non-Functional Requirements
Use the six requirements documented in statement.md.

## 6. System Architecture
The CLI communicates with Main.java. Main controls navigation and calls the student, administrator, quiz, result, and file-management classes. FileManager handles local data storage.

## 7. Design Decisions and Rationale
Java was selected because the project is for Programming in Java. A command-line interface keeps the project executable in a terminal without requiring GUI configuration. Text files provide simple persistent storage without an external database dependency. Separate classes keep responsibilities modular.

## 8. Implementation Details
The application uses an abstract User class with Student and Admin subclasses. Question represents an individual question, Quiz manages a collection of questions and calculates scores, Result represents a submitted result, QuizManager manages questions, and FileManager handles persistence.

## 9. Testing Approach
The project includes QuizTest.java. It verifies that a quiz containing known correct answers returns the expected score. Manual testing should also cover registration, login, invalid input, quiz submission, result display, and question management.

## 10. Results
During demonstration, show terminal screenshots for:
- Main menu
- Student registration
- Student login
- Quiz attempt
- Score/result
- Admin question management
- Automated test

## 11. Challenges Faced
Typical implementation challenges include validating user input, maintaining persistent data, separating application responsibilities into classes, and ensuring that score calculation uses the correct answers.

## 12. Learnings
The project demonstrates object-oriented design, inheritance, polymorphism, collections, file handling, exception handling, validation, and command-line application structure.

## 13. Future Enhancements
Possible improvements include database integration, password hashing, multiple categories, random questions, timed quizzes, leaderboards, and a web/GUI interface.

## 14. References
- Oracle Java Documentation: https://docs.oracle.com/en/java/
- Java Platform documentation and course materials.
