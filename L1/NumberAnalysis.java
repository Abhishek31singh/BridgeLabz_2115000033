import java.util.*;

public class NumberAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                if (numbers[i] % 2 == 0) {
                    System.out.println("Number " + (i + 1) + " (" + numbers[i] + ") is positive and even.");
                } else {
                    System.out.println("Number " + (i + 1) + " (" + numbers[i] + ") is positive and odd.");
                }
            } else if (numbers[i] < 0) {
                System.out.println("Number " + (i + 1) + " (" + numbers[i] + ") is negative.");
            } else {
                System.out.println("Number " + (i + 1) + " (" + numbers[i] + ") is zero.");
            }
        }

        if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("The first number (" + numbers[0] + ") is greater than the last number (" + numbers[numbers.length - 1] + ").");
        } else if (numbers[0] < numbers[numbers.length - 1]) {
            System.out.println("The first number (" + numbers[0] + ") is less than the last number (" + numbers[numbers.length - 1] + ").");
        } else {
            System.out.println("The first number (" + numbers[0] + ") is equal to the last number (" + numbers[numbers.length - 1] + ").");
        }
    }
}
