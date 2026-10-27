import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Initialize an array to store the fewest coins needed for each amount from 0 to amount
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        
        // Base case: 0 coins are needed to make an amount of 0
        dp[0] = 0;
        
        // Compute the minimum coins for all values from 1 to amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still max, it means the amount cannot be made up by any combination
        return dp[amount] > amount ? -1 : dp[amount];
    }
}