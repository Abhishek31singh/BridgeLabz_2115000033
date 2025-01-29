import java.util.*;
public class LongestWord{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence here---> ");
        String s = sc.nextLine();
        String[] arr = s.split("\\s+");
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > str.length()) {
                str = arr[i];
            }
        }

        System.out.println("The longest word in the sentence is -> " + str);
	}
}