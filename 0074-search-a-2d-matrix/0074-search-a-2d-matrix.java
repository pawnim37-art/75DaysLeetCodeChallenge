class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns
        
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int midIdx = left + (right - left) / 2;
            
            // Map flat index back to 2D coordinates
            int row = midIdx / n;
            int col = midIdx % n;
            int midValue = matrix[row][col];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = midIdx + 1;
            } else {
                right = midIdx - 1;
            }
        }

        return false;
    }
}