import java.util.*;

public class Duplicate {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> list2 = new ArrayList<>();
        for (int ele : list) {
            if (list2.contains(ele)) {
                continue;
            } else {
                list2.add(ele);
            }
        }
        System.out.println(list2);
    }

}
