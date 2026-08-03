class Solution {
    public int maximumCount(int[] nums) {

        int n = nums.length;

        // Find first index of element >= 0
        int low = 0;
        int high = n - 1;
        int firstNonNegative = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= 0) {
                firstNonNegative = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int negativeCount = firstNonNegative;

        // Find first index of element > 0
        low = 0;
        high = n - 1;
        int firstPositive = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > 0) {
                firstPositive = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int positiveCount = n - firstPositive;

        return Math.max(negativeCount, positiveCount);
    }
}