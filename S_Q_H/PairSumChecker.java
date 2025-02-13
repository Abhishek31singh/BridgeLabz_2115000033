import java.util.*;
class PairSumChecker {
    public boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 10};
        int target = 16;
        PairSumChecker checker = new PairSumChecker();
        boolean hasPair = checker.hasPairWithSum(arr, target);
        System.out.println("Pair exists: " + hasPair);
    }
}
