import java.util.Scanner;

public class TemperatureConvertor {
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Temperature Converter");
        System.out.print("Enter 'F' to convert Fahrenheit to Celsius or 'C' to convert Celsius to Fahrenheit: ");
        char choice = sc.next().toUpperCase().charAt(0);
        if (choice == 'F') {
            System.out.print("Enter temperature in Fahrenheit: ");
            double fahrenheit = sc.nextDouble();
            double celsius = fahrenheitToCelsius(fahrenheit);
            System.out.printf("%.2f°F is equal to %.2f°C\n", fahrenheit, celsius);
        } else if (choice == 'C') {
            System.out.print("Enter temperature in Celsius: ");
            double celsius = sc.nextDouble();
            double fahrenheit = celsiusToFahrenheit(celsius);
            System.out.printf("%.2f°C is equal to %.2f°F\n", celsius, fahrenheit);
        } else {
            System.out.println("Invalid choice. Please enter 'F' or 'C'.");
        }
        sc.close();
    }
}
