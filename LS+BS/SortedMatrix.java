class SortedMatrix{
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int midVal = matrix[row][col];

            if (midVal == target) {
                return true;
            } else if (target < midVal) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        int target = 5;
        boolean found = new SortedMatrix().searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + found);

         target = 20;
         found = new SortedMatrix().searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + found);
    }
}
