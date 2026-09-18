# Online Quiz Management System

A command-line Java application for conducting quizzes, managing questions, registering students, and storing quiz results.

## Features

- Student registration and login
- Admin login
- Quiz attempt through the terminal
- Automatic score calculation
- Student result history
- Admin question management
- Add, view, and remove questions
- File-based data storage
- Input validation and basic error handling

## Project Structure

```text
Online-Quiz-Management-System/
├── src/
│   ├── Main.java
│   ├── User.java
│   ├── Student.java
│   ├── Admin.java
│   ├── Question.java
│   ├── Quiz.java
│   ├── Result.java
│   ├── FileManager.java
│   └── QuizManager.java
├── tests/
│   └── QuizTest.java
├── data/
├── docs/
├── README.md
└── statement.md
```

## Requirements

- Java JDK 17 or later
- Terminal / Command Prompt
- No external libraries are required

Check Java:

```bash
java -version
javac -version
```

## Run the Project

From the repository root:

### Windows

```bash
javac -d out src\*.java
java -cp out Main
```

### Linux / macOS

```bash
javac -d out src/*.java
java -cp out Main
```

The program automatically creates the `data` directory and required files on first run.

## Default Admin Login

```text
Username: admin
Password: admin123
```

Students should use the registration option to create an account.

## Run the Test

Compile the test together with the source files:

### Windows

```bash
javac -d out src\*.java tests\QuizTest.java
java -cp out QuizTest
```

### Linux / macOS

```bash
javac -d out src/*.java tests/QuizTest.java
java -cp out QuizTest
```

Expected output:

```text
QuizTest passed.
```

## Data Files

The application creates:

- `data/users.txt` - student accounts
- `data/questions.txt` - quiz questions
- `data/results.txt` - quiz results

Do not commit passwords or other real personal information to a public repository. For a classroom demonstration, use dummy accounts only.

## Technologies

- Java 17+
- Object-Oriented Programming
- Java Collections
- File Handling
- Exception Handling
- Command-line interface
