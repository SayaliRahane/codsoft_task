import java.util.Scanner;
import java.util.concurrent.*;

public class QuizApplication {
    
    private static class Question {
        String questionText;
        String[] options;
        char correctAnswer;
        
        Question(String questionText, String[] options, char correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }
    
    private static final int TIME_LIMIT_SECONDS = 10;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Question[] questions = createQuestions();
        int totalQuestions = questions.length;
        int correctAnswers = 0;
        int incorrectAnswers = 0;
        
        System.out.println("===== JAVA QUIZ =====");
        System.out.println("You have " + TIME_LIMIT_SECONDS + " seconds for each question.");
        System.out.println();
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        for (int i = 0; i < totalQuestions; i++) {
            Question currentQuestion = questions[i];
            
            System.out.println("Question " + (i + 1) + ":");
            System.out.println(currentQuestion.questionText);
            System.out.println();
            
            for (int j = 0; j < currentQuestion.options.length; j++) {
                System.out.println((char) ('A' + j) + ". " + currentQuestion.options[j]);
            }
            
            System.out.println();
            System.out.println("Time remaining: " + TIME_LIMIT_SECONDS + " seconds");
            System.out.print("Enter your answer: ");
            
            char userAnswer = getAnswerWithTimeout(scanner, executor);
            
            if (userAnswer == '\0') {
                System.out.println("Time's up! No answer recorded.");
                incorrectAnswers++;
            } else {
                if (userAnswer == currentQuestion.correctAnswer) {
                    System.out.println("Correct!");
                    correctAnswers++;
                } else {
                    System.out.println("Incorrect! The correct answer was " + currentQuestion.correctAnswer + ".");
                    incorrectAnswers++;
                }
            }
            
            System.out.println();
        }
        
        executor.shutdown();
        
        System.out.println("===== QUIZ RESULT =====");
        System.out.println("Total Questions: " + totalQuestions);
        System.out.println("Correct Answers: " + correctAnswers);
        System.out.println("Incorrect Answers: " + incorrectAnswers);
        System.out.println("Score: " + correctAnswers + "/" + totalQuestions);
        double percentage = ((double) correctAnswers / totalQuestions) * 100;
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println();
        System.out.println("Thank you for playing!");
        
        scanner.close();
    }
    
    private static Question[] createQuestions() {
        Question[] questions = new Question[5];
        
        questions[0] = new Question(
            "Which keyword is used to inherit a class in Java?",
            new String[]{"implements", "extends", "inherits", "super"},
            'B'
        );
        
        questions[1] = new Question(
            "What is the entry point of a Java program?",
            new String[]{"start()", "main()", "init()", "run()"},
            'B'
        );
        
        questions[2] = new Question(
            "Which data type is used to store text in Java?",
            new String[]{"char", "String", "text", "varchar"},
            'B'
        );
        
        questions[3] = new Question(
            "What is the size of an int in Java?",
            new String[]{"16 bits", "32 bits", "64 bits", "8 bits"},
            'B'
        );
        
        questions[4] = new Question(
            "Which keyword is used to create a constant in Java?",
            new String[]{"static", "final", "const", "constant"},
            'B'
        );
        
        return questions;
    }
    
    private static char getAnswerWithTimeout(Scanner scanner, ExecutorService executor) {
        Future<Character> future = executor.submit(() -> {
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 0) {
                return '\0';
            }
            return input.charAt(0);
        });
        
        try {
            return future.get(TIME_LIMIT_SECONDS, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            future.cancel(true);
            return '\0';
        } catch (Exception e) {
            return '\0';
        }
    }
}
