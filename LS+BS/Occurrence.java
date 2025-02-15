class Occurrence{
    public int[] findFirstAndLast(int[] arr, int target) {
        int first = -1;
        int last = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1; // Search left for first occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = 0;
        right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = new Occurrence().findFirstAndLast(arr, target);
        System.out.println("First occurrence: " + result[0]);
        System.out.println("Last occurrence: " + result[1]);

        int[] arr2 = {5, 7, 7, 8, 8, 10};
        target = 6;
        result = new Occurrence().findFirstAndLast(arr2, target);
        System.out.println("First occurrence: " + result[0]);
        System.out.println("Last occurrence: " + result[1]);

    }
}
