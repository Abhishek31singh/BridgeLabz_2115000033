import java.util.*;
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); 
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return (i + 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of product prices: ");
        int n = scanner.nextInt();
        int[] productPrices = new int[n];
        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            productPrices[i] = scanner.nextInt();
        }
        quickSort(productPrices, 0, n - 1);
        System.out.println("Sorted product prices:");
        for (int price : productPrices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
}
