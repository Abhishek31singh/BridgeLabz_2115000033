import java.util.Scanner;

public class YTFriend {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amar = scanner.nextInt();
        int akbar = scanner.nextInt();
        int anthony= scanner.nextInt();
        double amarHeight = scanner.nextDouble();
        double akbarHeight = scanner.nextDouble();
        double anthonyHeight = scanner.nextDouble();
        String youngestFriend;
        if (amar <= akbar && amar <= anthony) {
            youngestFriend = "Amar";
        } else if (akbar <= amar && akbar <= anthony) {
            youngestFriend = "Akbar";
        } else {
            youngestFriend = "Anthony";
        }
        String tallestFriend;
        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            tallestFriend = "Amar";
        } else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight) {
            tallestFriend = "Akbar";
        } else {
            tallestFriend = "Anthony";
        }
        System.out.println("Youngest Friend: " + youngestFriend);
        System.out.println("Tallest Friend: " + tallestFriend);
    }
}
