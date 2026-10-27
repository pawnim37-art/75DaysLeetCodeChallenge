class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // dp[i][j] represents the minimum number of operations required 
        // to convert word1[0...i-1] to word2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Base cases: 
        // Converting empty string to word2 of length j requires j insertions
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        // Converting word1 of length i to empty string requires i deletions
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match, no operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1], // Replace
                        Math.min(
                            dp[i - 1][j], // Delete
                            dp[i][j - 1]  // Insert
                        )
                    );
                }
            }
        }
        
        return dp[m][n];
    }
}