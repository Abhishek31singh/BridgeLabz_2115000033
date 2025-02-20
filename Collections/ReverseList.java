import java.util.*;
public class ReverseList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        System.out.println("Original arraylist" + list);
        list = reverse(list);
        System.out.println("Reverse arrayList" + list);
        System.out.println("Original linkedList " + list2);
        list2 = reverse(list2);
        System.out.println("Reverse linkedList" + list2);

    }

    public static <T> List<T> reverse(List<T> list) {
        List<T> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }
}





















