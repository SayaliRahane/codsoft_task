# CODSOFT Java Internship Tasks

This repository contains Java programming tasks completed as part of the CODSOFT internship program. All tasks are implemented using Core Java with console-based interfaces, demonstrating fundamental programming concepts including loops, conditionals, object-oriented programming, input validation, and multithreading.


## Technologies Used

- Java (Core Java)
- Object-Oriented Programming (OOP)
- Java Standard Library
- Collections (where applicable)
- Multithreading (ExecutorService for Quiz timer)

## Tasks Completed

### Task 1 — Number Game
A console-based number guessing game where the user tries to guess a random number between 1 and 100. Features include:
- Random number generation
- Input validation
- Attempt tracking
- Score calculation based on attempts
- Multiple rounds support

### Task 2 — Student Grade Calculator
A console-based grade calculator that computes student grades based on marks obtained in multiple subjects. Features include:
- Dynamic number of subjects
- Marks validation (0-100 range)
- Total marks calculation
- Average percentage calculation
- Grade assignment based on percentage

### Task 3 — ATM Interface
A console-based ATM interface demonstrating Object-Oriented Programming principles. Features include:
- BankAccount class with encapsulation
- ATM class for user interaction
- Deposit and withdrawal functionality
- Balance checking
- Input validation
- Transaction menu system

### Task 4 — Quiz Application
A console-based multiple-choice quiz application with a timer feature. Features include:
- Multiple quiz questions with options
- 10-second timer per question using ExecutorService
- Score calculation
- Result summary with percentage
- Timeout handling

## Project Structure

```
CODSOFT_TASKSNO/
│
├── Task1_NumberGame/
│   └── NumberGame.java
│
├── Task2_StudentGradeCalculator/
│   └── StudentGradeCalculator.java
│
├── Task3_ATMInterface/
│   ├── BankAccount.java
│   ├── ATM.java
│   └── Main.java
│
├── Task4_QuizApplication/
│   └── QuizApplication.java
│
└── README.md
```

## How to Run

### Prerequisites
- Java Development Kit (JDK) 17 or higher
- A text editor or IDE (optional)

### Compilation and Execution

Navigate to the task directory and compile the Java file(s):

**Task 1 — Number Game:**
```bash
cd Task1_NumberGame
javac NumberGame.java
java NumberGame
```

**Task 2 — Student Grade Calculator:**
```bash
cd Task2_StudentGradeCalculator
javac StudentGradeCalculator.java
java StudentGradeCalculator
```

**Task 3 — ATM Interface:**
```bash
cd Task3_ATMInterface
javac *.java
java Main
```

**Task 4 — Quiz Application:**
```bash
cd Task4_QuizApplication
javac QuizApplication.java
java QuizApplication
```

## Task Descriptions

### Task 1 — Number Game
The Number Game generates a random number between 1 and 100. The user has up to 10 attempts to guess the correct number. The game provides feedback ("Too High!" or "Too Low!") and calculates a score based on the number of attempts. Users can play multiple rounds and track their total score.

### Task 2 — Student Grade Calculator
This calculator accepts the number of subjects and marks obtained in each subject (out of 100). It validates the input, calculates total marks,平均 percentage, and assigns a grade based on the following scale:
- 90-100: A+
- 80-89: A
- 70-79: B
- 60-69: C
- 50-59: D
- 40-49: E
- Below 40: F

### Task 3 — ATM Interface
This task demonstrates OOP principles with three classes:
- **BankAccount**: Manages account balance with private fields and public methods for deposit, withdrawal, and balance checking
- **ATM**: Provides the user interface and handles user interactions
- **Main**: Entry point that initializes the system with a starting balance of ₹10,000

The ATM allows users to check balance, deposit money, withdraw money, and exit the system.

### Task 4 — Quiz Application
The Quiz Application presents 5 Java-related multiple-choice questions. Each question has a 10-second timer. If the user doesn't answer within the time limit, the question is marked as incorrect. The quiz displays a final result with the number of correct answers, incorrect answers, score, and percentage.

## Sample Features

- **Input Validation**: All applications handle invalid input gracefully without crashing
- **Clean User Interface**: Each application has a clear, professional console interface
- **Error Handling**: Proper exception handling for numeric input and edge cases
- **Code Organization**: Well-structured code with meaningful variable names and proper indentation
- **OOP Principles**: Encapsulation demonstrated in the ATM task
- **Multithreading**: Safe timer implementation using ExecutorService in the Quiz application

## Author

This project was completed as part of the CODSOFT Java Internship program.
