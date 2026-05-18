class Solution {
    public int findPeakElement(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Peak is on right side
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            // Peak is on left side or mid itself
            else {
                right = mid;
            }
        }

        return left;
    }
}