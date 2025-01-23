import java.util.Scanner;
public class PrimeNumberCheck {
    public static void checkPrimeNumber(int number) {
        if (number <= 1) {
            System.out.println(number + "not prime number");
            return;
        }
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println(number + "  prime number");
        } else {
            System.out.println(number + " not prime number");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = scanner.nextInt();
        checkPrimeNumber(num);
    }
}
