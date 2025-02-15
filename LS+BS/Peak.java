class Peak {
    public int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return mid;
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int peakIndex = new Peak().findPeakElement(arr);
        System.out.println("Peak element index: " + peakIndex);

        int[] arr2 = {1, 2, 1, 3, 5, 6, 4};
        peakIndex = new Peak().findPeakElement(arr2);
        System.out.println("Peak element index: " + peakIndex);

        int[] arr3 = {1,2,3,4,5};
        peakIndex = new Peak().findPeakElement(arr3);
        System.out.println("Peak element index: " + peakIndex);

    }
}
