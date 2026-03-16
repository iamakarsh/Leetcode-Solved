class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }
        int ans = high;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canSplit(nums, k, mid)){
                ans = mid;
                high = mid - 1;
            } 
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    boolean canSplit(int[] nums, int k, int maxSum){
        int subarrays = 1;
        int currSum = 0;
        for(int num : nums){
            currSum += num;
            if(currSum > maxSum){
                subarrays++;
                currSum = num;

                if(subarrays > k) return false;
            }
        }
        return true;
    }
}