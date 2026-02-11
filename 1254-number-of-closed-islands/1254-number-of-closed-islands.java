class Solution {

    class Pair {
        int row, col;
        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    int[] dir_r = {1, -1, 0, 0};
    int[] dir_c = {0, 0, 1, -1};

    public boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public void bfs(int[][] grid, boolean[][] vis, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int r = cur.row;
            int c = cur.col;

            for (int i = 0; i < 4; i++) {
                int nr = r + dir_r[i];
                int nc = c + dir_c[i];

                if (isValid(nr, nc, n, m) &&
                    grid[nr][nc] == 0 &&
                    !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        // first and last row
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 0 && !vis[0][i])
                bfs(grid, vis, 0, i);

            if (grid[n - 1][i] == 0 && !vis[n - 1][i])
                bfs(grid, vis, n - 1, i);
        }

        // first and last column
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0 && !vis[i][0])
                bfs(grid, vis, i, 0);

            if (grid[i][m - 1] == 0 && !vis[i][m - 1])
                bfs(grid, vis, i, m - 1);
        }

        int count = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 0 && !vis[i][j]) {
                    count++;
                    bfs(grid, vis, i, j);
                }
            }
        }

        return count;
    }
}
