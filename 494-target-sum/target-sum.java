class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum + target < 0 || (sum + target) % 2 != 0) {
            return 0;
        }
        int s1 = (sum + target) / 2;
        int n = nums.length;
        int[][] dp = new int[n][s1 + 1];
        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }
        if (nums[0] != 0 && nums[0] <= s1) {
            dp[0][nums[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int tar = 0; tar <= s1; tar++) {
                int notTake = dp[i - 1][tar];
                int take = 0;
                if (nums[i] <= tar) {
                    take = dp[i - 1][tar - nums[i]];
                }
                dp[i][tar] = take + notTake;
            }
        }
        return dp[n - 1][s1];
    }
}