import java.util.Scanner;

public class Student {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        int pMarks = scanner.nextInt();

        
        int cMarks = scanner.nextInt();

    
        int mMarks = scanner.nextInt();
        int total = pMarks + cMarks + mMarks;
        double average = (double) total / 3;
        double percentage = (average / 300) * 100;

        char grade;
        String remarks;

        if (percentage >= 80) {
            grade = 'A';
            remarks = "(Level 4, above agency-normalized standards)";
        } else if (percentage >= 70) {
            grade = 'B';
         remarks = "(Level 3, at agency-normalized standards)";
        } else if (percentage >= 60) {
            grade = 'C';
            remarks = "(Level 2, below, but approaching agency-normalized standards)";
        } else if (percentage >= 50) {
            grade = 'D';
            remarks = "(Level 1, well below agency-normalized standards)";
        } else if (percentage >= 40) {
            grade = 'E';
            remarks = "(Level 1-, too below agency-normalized standards)";
        } else {
            grade = 'R';
            remarks = "(Remedial standards)";
        }

        System.out.println("\nAverage Marks: " + average);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
    }
}
