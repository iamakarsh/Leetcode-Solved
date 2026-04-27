class Solution {
    //tabulation
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][0]=Math.max(dp[i + 1][0],dp[i + 1][1]-prices[i]);//skip or buy
            dp[i][1]=Math.max(dp[i + 1][1],dp[i + 1][0]+prices[i]);//skip or sell
        }
        return dp[0][0];
    }
}