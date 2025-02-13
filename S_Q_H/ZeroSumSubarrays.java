import java.util.*;
class ZeroSumSubarrays {
    public List<List<Integer>> findSubarrays(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (sumMap.containsKey(currentSum)) {
                List<Integer> startIndexList = sumMap.get(currentSum);
                for (int startIndex : startIndexList) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = startIndex + 1; j <= i; j++) {
                        subarray.add(nums[j]);
                    }
                    result.add(subarray);
                }
            }
            sumMap.computeIfAbsent(currentSum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {4, 2, -3, 1, 6};
        ZeroSumSubarrays finder = new ZeroSumSubarrays();
        List<List<Integer>> subarrays = finder.findSubarrays(nums);
        for (List<Integer> subarray : subarrays) {
            System.out.println(subarray);
        }
    }
}

