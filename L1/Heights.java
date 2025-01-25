import java.util.Scanner;

public class Heights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11]; 
        System.out.println("Enter the heights of 11 players (in meters):");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
        }
        double sum = 0;
        for (double height : heights) {
            sum += height;
        }
        double meanHeight = sum / heights.length; 
        System.out.println("Mean height of the football team: " + meanHeight + " meters");
    }
}
