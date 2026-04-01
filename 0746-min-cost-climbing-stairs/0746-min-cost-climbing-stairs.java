class Solution {
    int[] dp;
    public int solve(int[] cost, int i) {
        if (i < 0) return 0;
        if (i == 0 || i == 1) return cost[i];
        if (dp[i] != -1) return dp[i];
        return dp[i] = cost[i] + Math.min(solve(cost, i - 1), solve(cost, i - 2));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(solve(cost, n - 1), solve(cost, n - 2));
    }
}