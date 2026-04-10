class Solution {
    int[][][] dp;
    int n;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        dp = new int[n][n][n];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        int res = Math.max(0, solve(0, 0, 0, grid));
        return res;
    }
    int solve(int r1, int c1, int r2, int[][] grid) {
        int c2 = r1 + c1 - r2;
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return (int)-1e9;
        }
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }
        if (dp[r1][c1][r2] != Integer.MIN_VALUE) {
            return dp[r1][c1][r2];
        }
        int cherries = 0;
        if (r1 == r2 && c1 == c2) {
            cherries = grid[r1][c1];
        } else {
            cherries = grid[r1][c1] + grid[r2][c2];
        }
        int ans = Math.max(
            Math.max(solve(r1 + 1, c1, r2 + 1, grid),solve(r1 + 1, c1, r2, grid)),Math.max(solve(r1, c1 + 1, r2 + 1, grid),solve(r1, c1 + 1, r2, grid)));
        cherries += ans;
        return dp[r1][c1][r2] = cherries;
    }
}