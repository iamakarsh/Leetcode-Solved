class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowStart=0;
        int windowEnd=0;

        int maxSum=Integer.MIN_VALUE;
        int currSum=0;

        while(windowEnd<nums.length) {
            currSum+=nums[windowEnd];

            if(windowEnd>=k-1) {
                maxSum=Math.max(currSum,maxSum);
                currSum-=nums[windowStart];
                windowStart++;
            }
            windowEnd++;
        }
        
        return (double)maxSum/k;
    }
}