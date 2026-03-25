class Solution {
    int[][] dp;
    int n;
    public int solve(int[][] pairs, int i, int prev) {
        if (i >= n) return 0;
        if (dp[i][prev + 1] != -1) return dp[i][prev + 1];
        int take = 0;
        if (prev == -1 || pairs[prev][1] < pairs[i][0]) {
            take = 1 + solve(pairs, i + 1, i);
        }
        int skip = solve(pairs, i + 1, prev);
        return dp[i][prev + 1] = Math.max(take, skip);
    }

    public int findLongestChain(int[][] pairs) {
        n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(pairs, 0, -1);
    }
}