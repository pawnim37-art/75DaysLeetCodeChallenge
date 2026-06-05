class Solution {
    public boolean canJump(int[] nums) {

        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            // If current index cannot be reached
            if (i > farthest) {
                return false;
            }

            // Update farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);

            // If last index reached
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}