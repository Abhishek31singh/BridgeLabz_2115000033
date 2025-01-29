import java.util.Scanner;

public class GCDLCMCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
        scanner.close();
    }

    private static int calculateGCD(int a, int b) {
        if (b == 0)
            return a;
        return calculateGCD(b, a % b);
    }

    private static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}
