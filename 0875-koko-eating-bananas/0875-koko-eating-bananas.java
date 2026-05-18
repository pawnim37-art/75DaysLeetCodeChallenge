class Solution {
    
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right = 0;

        // Find maximum pile
        for (int bananas : piles) {
            right = Math.max(right, bananas);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            long hours = calculateHours(piles, mid);

            // Can finish within h hours
            if (hours <= h) {
                right = mid;
            } 
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long calculateHours(int[] piles, int speed) {

        long totalHours = 0;

        for (int bananas : piles) {

            totalHours += (bananas + speed - 1) / speed;
        }

        return totalHours;
    }
}