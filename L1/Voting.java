import java.util.*;

public class Voting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] studentAges = new int[10];
        System.out.println("Enter the ages of 10 students:");
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();
        }
        for (int i = 0; i < studentAges.length; i++) {
            int age = studentAges[i];
            if (age < 0) {
                System.out.println("Student " + (i + 1) + ": Invalid age.");
            } else if (age >= 18) {
                System.out.println("Student " + (i + 1) + " (age " + age + ") can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " (age " + age + ") cannot vote.");
            }
        }
    }
}
