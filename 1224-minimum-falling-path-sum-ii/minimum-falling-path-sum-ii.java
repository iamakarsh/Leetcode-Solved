class Solution {
    int [][]dp;
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=-0;j<n;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        int ans=Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans,solve(grid,0,j));
        }
        return ans;
    }
    public int solve(int[][] grid, int i, int j) {
        int n = grid.length;
        if (i == n - 1) return grid[i][j];
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            if (k != j) {
                min = Math.min(min, solve(grid, i + 1, k));
            }
        }
        return dp[i][j] = grid[i][j] + min;
    }
}