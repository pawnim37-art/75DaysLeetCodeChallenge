import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        
        for (int x : nums) {
            // Binary search to find the insert position of x in tails[0 ... size-1]
            int i = 0, j = size;
            while (i < j) {
                int mid = i + (j - i) / 2;
                if (tails[mid] < x) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            
            tails[i] = x;
            if (i == size) {
                size++;
            }
        }
        
        return size;
    }
}