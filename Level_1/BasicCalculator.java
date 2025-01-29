import java.util.Scanner;

public class BasicCalculator {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error! Division by zero.");
            return Double.NaN;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Basic Calculator");
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        System.out.println("Choose operation: ");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.print("Enter choice (1/2/3/4): ");
        int choice = sc.nextInt();
        double result = 0;
        switch (choice) {
            case 1:
                result = add(num1, num2);
                System.out.printf("Result: %.2f\n", result);
                break;
            case 2:
                result = subtract(num1, num2);
                System.out.printf("Result: %.2f\n", result);
                break;
            case 3:
                result = multiply(num1, num2);
                System.out.printf("Result: %.2f\n", result);
                break;
            case 4:
                result = divide(num1, num2);
                if (!Double.isNaN(result)) {
                    System.out.printf("Result: %.2f\n", result);
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
        sc.close();
    }
}
