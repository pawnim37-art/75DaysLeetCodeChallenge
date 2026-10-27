class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k == 0) {
            return 0;
        }

        int n = prices.length;

        // Optimization: If k is greater than or equal to n / 2, 
        // it's equivalent to making unlimited transactions.
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // buy[j]: Maximum profit after buying stock for the (j+1)-th time
        // sell[j]: Maximum profit after selling stock for the (j+1)-th time
        int[] buy = new int[k];
        int[] sell = new int[k];

        // Initialize buy states to Integer.MIN_VALUE / 2 (or -prices[0])
        for (int j = 0; j < k; j++) {
            buy[j] = -prices[0];
        }

        // DP state transitions
        for (int i = 1; i < n; i++) {
            int price = prices[i];
            
            // First transaction
            buy[0] = Math.max(buy[0], -price);
            sell[0] = Math.max(sell[0], buy[0] + price);
            
            // Subsequent transactions
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }

        return sell[k - 1];
    }
}