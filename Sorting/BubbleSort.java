import java.util.*;
class BubbleSort{
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        BubbleSort solution = new BubbleSort();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of marks: ");
        int n = scanner.nextInt();
        int[] marks = new int[n];
        System.out.println("Enter the marks:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }
        solution.bubbleSort(marks);
        System.out.println("Sorted marks:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
}
