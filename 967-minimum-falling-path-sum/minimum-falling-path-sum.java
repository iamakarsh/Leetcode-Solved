class Solution {
    int [][]dp;
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=-0;j<n;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            ans=Math.min(ans,solve(matrix,0,j));
        }
        return ans;
    }
    public int solve(int[][] matrix,int i,int j){
        int n=matrix.length;
        if (j < 0 || j >= n) return Integer.MAX_VALUE;
        if (i == n - 1) return matrix[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];

        int down = solve(matrix, i + 1, j);
        int leftDiag = solve(matrix, i + 1, j - 1);
        int rightDiag = solve(matrix, i + 1, j + 1);

        return dp[i][j] = matrix[i][j]+Math.min(down, Math.min(leftDiag, rightDiag));

    }
}