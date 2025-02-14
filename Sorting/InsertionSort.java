import java.util.*;
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of employee IDs: ");
        int n = scanner.nextInt();
        int[] employeeIds = new int[n];
        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            employeeIds[i] = scanner.nextInt();
        }
        insertionSort(employeeIds);
        System.out.println("Sorted employee IDs:");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
        System.out.println();
    }
}
