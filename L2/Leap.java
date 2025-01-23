import java.util.Scanner;

public class Leap {
    
    public static void checkLeapYear(int year) {
        if (year < 1582) {
            System.out.println("Year should be 1582 or later, as the Gregorian calendar was introduced in 1582.");
            return;
        }
        if (year % 400 == 0) {
            System.out.println(year + "  Leap Year");
        } else if (year % 100 == 0) {
            System.out.println(year + " not  Leap Year");
        } else if (year % 4 == 0) {
            System.out.println(year + "  Leap Year");
        } else {
            System.out.println(year + "  not  Leap Year");
        }
        if (year >= 1582 && ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))) {
            System.out.println(year + "  Leap Year (from second condition )");
        } else {
            System.out.println(year + " is not a Leap Year (from second condition )");
        }
    }
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year:- ");
        int year = scanner.nextInt();
        checkLeapYear(year);
        }
}
