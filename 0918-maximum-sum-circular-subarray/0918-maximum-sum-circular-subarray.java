class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        int currMax = 0, maxSum = nums[0];
        int currMin = 0, minSum = nums[0];
        
        for (int num : nums) {
            // Standard Kadane for max subarray
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);
            
            // Reverse Kadane for min subarray
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
            
            totalSum += num;
        }
        
        // If all elements are negative
        if (maxSum < 0) {
            return maxSum;
        }
        
        // Return maximum of normal and circular sum
        return Math.max(maxSum, totalSum - minSum);
    }
}
