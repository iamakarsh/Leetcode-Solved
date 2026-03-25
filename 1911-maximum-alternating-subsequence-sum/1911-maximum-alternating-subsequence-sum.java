class Solution {
    long[][] dp;
    int n;

    public long solve(int idx, int[] nums, int flag) {
        if (idx >= n) return 0;
        if (dp[idx][flag] != -1) return dp[idx][flag];
        long skip = solve(idx + 1, nums, flag);
        long val = nums[idx];
        if (flag == 0) {  
            val = -val;
        }
        long take = val + solve(idx + 1, nums, 1 - flag);
        return dp[idx][flag] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        dp = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, nums, 1);
    }
}