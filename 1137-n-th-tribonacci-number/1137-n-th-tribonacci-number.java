class Solution {
    static int[] dp;
    public int tribo(int n){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=tribo(n-1)+tribo(n-2)+tribo(n-3);
    }
    public int tribonacci(int n) {
        dp=new int[n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp,-1);
        }
        return tribo(n);
    }
}