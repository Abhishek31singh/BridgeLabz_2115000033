import java.util.*;
public class ArrayInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double number = scanner.nextDouble();
            if (number <= 0 || index >= 10) {
                break;
            }
            numbers[index] = number;
            index++;
        }
        System.out.println("Entered numbers:");
        for (int i = 0; i < index; i++) {
            System.out.println("Number " + (i + 1) + ": " + numbers[i]);
            total += numbers[i];
        }
        System.out.println(total);
    }
}
