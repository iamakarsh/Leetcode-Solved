class Solution {
    public int longestSubarray(int[] nums) {
        int count=0;
        int max=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
           if(nums[right]==0){
            count++;
           }
           if(count>1 && nums[right]==0){
            while(count>1){
                if(nums[left]==0){
                    count--;
                }
                left++;
            }
           }
           max=Math.max(max,right-left);
        }
        return max;
    }
}