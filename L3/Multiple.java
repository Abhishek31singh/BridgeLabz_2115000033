import java.util.Scanner;
public class Multiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Multiples of " + number + " below 100 are:");
        for (int i = 1; i <= 100; i++) {
            if (i % number == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
