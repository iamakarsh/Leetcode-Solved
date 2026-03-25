class Solution {
    int[] dp;
    public int solve(int[] nums, int i, int n) {
        if (i > n) return 0;
        if (dp[i] != -1) return dp[i];
        int take = nums[i] + solve(nums, i + 2, n);
        int skip = solve(nums, i + 1, n); 
        return dp[i] = Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        dp = new int[n];
        Arrays.fill(dp, -1);
        int case1 = solve(nums, 0, n - 2);
        Arrays.fill(dp, -1);
        int case2 = solve(nums, 1, n - 1);
        return Math.max(case1, case2);
    }
}