import java.util.*;
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of exam scores: ");
        int n = scanner.nextInt();
        int[] examScores = new int[n];
        System.out.println("Enter the exam scores:");
        for (int i = 0; i < n; i++) {
            examScores[i] = scanner.nextInt();
        }
        selectionSort(examScores);
        System.out.println("Sorted exam scores:");
        for (int score : examScores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
}
