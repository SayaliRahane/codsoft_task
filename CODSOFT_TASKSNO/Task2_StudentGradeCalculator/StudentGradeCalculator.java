import java.util.Scanner;

public class StudentGradeCalculator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== STUDENT GRADE CALCULATOR =====");
        System.out.println();
        
        int numberOfSubjects = getNumberOfSubjects(scanner);
        
        if (numberOfSubjects <= 0) {
            System.out.println("Invalid number of subjects. Exiting.");
            scanner.close();
            return;
        }
        
        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;
        
        for (int i = 0; i < numberOfSubjects; i++) {
            marks[i] = getMarksForSubject(scanner, i + 1);
            totalMarks += marks[i];
        }
        
        int maximumMarks = numberOfSubjects * 100;
        double averagePercentage = (double) totalMarks / numberOfSubjects;
        String grade = calculateGrade(averagePercentage);
        
        System.out.println();
        System.out.println("===== RESULT =====");
        System.out.println("Total Marks: " + totalMarks + "/" + maximumMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
    
    private static int getNumberOfSubjects(Scanner scanner) {
        while (true) {
            System.out.print("Enter number of subjects: ");
            
            try {
                String input = scanner.nextLine();
                int num = Integer.parseInt(input);
                
                if (num <= 0) {
                    System.out.println("Number of subjects must be greater than 0.");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
    
    private static int getMarksForSubject(Scanner scanner, int subjectNumber) {
        while (true) {
            System.out.print("Enter marks for Subject " + subjectNumber + ": ");
            
            try {
                String input = scanner.nextLine();
                int marks = Integer.parseInt(input);
                
                if (marks < 0 || marks > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                } else {
                    return marks;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
    
    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else if (averagePercentage >= 40) {
            return "E";
        } else {
            return "F";
        }
    }
}
