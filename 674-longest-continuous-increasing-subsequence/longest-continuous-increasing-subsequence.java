class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}