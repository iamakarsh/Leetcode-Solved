import java.util.Arrays;
import java.util.List;

class Solution {
    public int solve(int row, int col, List<List<Integer>> triangle, int[][] dp) {
        int n = triangle.size();        
        if (row == n - 1) return triangle.get(row).get(col);
        
        // Check against Integer.MIN_VALUE instead of -1
        if (dp[row][col] != Integer.MIN_VALUE) return dp[row][col];
        
        int left = solve(row + 1, col, triangle, dp);
        int right = solve(row + 1, col + 1, triangle, dp);
        return dp[row][col] = triangle.get(row).get(col) + Math.min(left, right);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return solve(0, 0, triangle, dp);
    }
}