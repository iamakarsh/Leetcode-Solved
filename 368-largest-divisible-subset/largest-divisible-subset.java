class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int[]dp=new int[n+1];
        int[]par=new int[n];
        for(int i=0;i<n;i++) par[i]=i;
        Arrays.fill(dp,1);
        int maxi=0;
        int itr=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        par[i]=j;
                    }
                }
                if(dp[i]>maxi){
                    maxi=dp[i];
                    itr=i;
                }
            }
        }
        while(par[itr]!=itr){
            ans.add(nums[itr]);
            itr=par[itr];
        }
        ans.add(nums[itr]);
        return ans;
        
        
    }
}