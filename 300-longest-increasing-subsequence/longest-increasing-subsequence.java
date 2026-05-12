class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==1) return 1;
        int[]lis=new int[n+1];
        Arrays.fill(lis,1);
        int ans=0;
        for(int i=1;i<n;i++){
            int j=i-1;
            while(j>=0){
                if(nums[i]>nums[j]){
                    lis[i]=Math.max(lis[i],1+lis[j]);
                }
                j--;
            }
            ans=Math.max(ans,lis[i]);
        }
        return ans;
    }
}