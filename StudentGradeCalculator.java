import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("WELLCOME TO THE 'STUDENT GRADE CALCULATOR'.");

        System.out.print("Enter the number of subjects: "); // Input number of subjects
        int totalSubject = scanner.nextInt();

        // Declare array to hold marks and initialize total marks
        int[] marks = new int[totalSubject];
        int totalMarks = 0;

        for (int i = 0; i < totalSubject; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": "); // Input marks for each subject
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / totalSubject;

        // Grade Calculation
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Final results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
