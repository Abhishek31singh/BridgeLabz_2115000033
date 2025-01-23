import java.util.Scanner;
public class Power {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int power = scanner.nextInt();
        int result = 1;
        for (int i = 1; i <= power; i++) {
            result = result * number;
        }
        System.out.println(number + " raised to the power of " + power + " is: " + result);
    }
}
