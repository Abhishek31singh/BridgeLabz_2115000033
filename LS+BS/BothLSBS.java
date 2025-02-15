import java.util.*;
class BothLSBS{
    public int firstMissingPositiveLinear(int[] nums) {
        int n = nums.length;
        boolean containsOne = false;
        for (int x : nums) {
            if (x == 1) {
                containsOne = true;
                break;
            }
        }
        if (!containsOne) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            if (a == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return n;
        }

        return n + 1;
    }
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        BothLSBS solution = new BothLSBS();
        int[] nums = {3, 4, -1, 1};
        int missingPositive = solution.firstMissingPositiveLinear(nums);
        System.out.println("First missing positive (Linear): " + missingPositive);
        int[] sortedNums = {2, 5, 7, 8, 11, 12};
        int target = 11;
        int index = solution.binarySearch(sortedNums, target);
        System.out.println("Index of " + target + " (Binary): " + index);
        int[] nums2 = {7,8,9,11,12};
        missingPositive = solution.firstMissingPositiveLinear(nums2);
        System.out.println("First missing positive (Linear): " + missingPositive);
        target = 10;
        index = solution.binarySearch(sortedNums, target);
        System.out.println("Index of " + target + " (Binary): " + index);
    }
}
