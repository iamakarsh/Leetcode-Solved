class Solution {
    int[] dp=new int[46];
    public int solve(int n){
        if(n<0) return 0;
        if(n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        int one_step=solve(n-1);
        int two_step=solve(n-2);
        return dp[n]=one_step+two_step;
    }
    public int climbStairs(int n) {
        for(int i=0;i<46;i++){
            dp[i]=-1;
        }
        return solve(n);
    }
}