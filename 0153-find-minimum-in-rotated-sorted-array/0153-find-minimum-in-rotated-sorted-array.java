class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // Minimum is mid or in the left half
                right = mid;
            }
        }

        // After the loop, left == right, pointing to the minimum
        return nums[left];
    }
}