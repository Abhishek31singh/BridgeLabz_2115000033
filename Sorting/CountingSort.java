import java.util.*;
public class CountingSort {
    public static void countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] ages = new int[n];
        System.out.println("Enter the student ages (between 10 and 18 inclusive):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }
        int minAge = 10;
        int maxAge = 18;
        countingSort(ages, minAge, maxAge);
        System.out.println("Sorted student ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }
}
