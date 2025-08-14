import java.util.HashMap;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> subjectMarks = new HashMap<>();

        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter subject names: ");
        String[] subjects = sc.nextLine().split(",");

        System.out.print("Enter marks obtained: ");
        String[] marksInput = sc.nextLine().split(",");
        if (subjects.length != numSubjects || marksInput.length != numSubjects) {
            System.out.println("Number of subjects and marks must match the specified count.");
            return;
        }

        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            String subject = subjects[i].trim();
            int marks;
            try {
                marks = Integer.parseInt(marksInput[i].trim());
                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks for " + subject + ". Must be between 0 and 100.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for marks: " + marksInput[i]);
                return;
            }

            subjectMarks.put(subject, marks);
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numSubjects;
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("\n--- Report Card ---");
        for (String subject : subjectMarks.keySet()) {
            System.out.println(subject + ": " + subjectMarks.get(subject));
        }
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
}
