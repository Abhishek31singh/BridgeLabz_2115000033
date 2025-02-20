import java.util.*;

public class ElementFromend {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('E');

        int N = 2;
        System.out.println(findNthFromEnd(list, N));
    }

    public static Character findNthFromEnd(LinkedList<Character> list, int N) {
        ListIterator<Character> slow = list.listIterator();
        ListIterator<Character> fast = list.listIterator();
        for (int i = 0; i < N; i++) {
            if (fast.hasNext()) {
                fast.next();
            }
        }
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }
}