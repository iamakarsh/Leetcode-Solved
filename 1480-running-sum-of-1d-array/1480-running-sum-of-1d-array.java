class Solution {
    public int[] runningSum(int[] nums) {
        int rs[]=new int[nums.length];
        rs[0]=nums[0];
       int sum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
           sum=sum+nums[i];
           rs[i]=sum;
        }
        return rs;
    }
}