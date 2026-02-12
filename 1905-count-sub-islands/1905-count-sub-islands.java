class Solution {

    class Pair {
        int row, col;
        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    public boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public boolean bfs(int[][] grid1, int[][] grid2,
                       boolean[][] vis, int row, int col) {

        int n = grid2.length;
        int m = grid2[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = true;

        boolean isSubIsland = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int r = cur.row;
            int c = cur.col;

            // check if this cell is land in grid1
            if (grid1[r][c] == 0) {
                isSubIsland = false;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isValid(nr, nc, n, m) &&
                    grid2[nr][nc] == 1 &&
                    !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        return isSubIsland;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length;
        int m = grid2[0].length;

        boolean[][] vis = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1 && !vis[i][j]) {
                    if (bfs(grid1, grid2, vis, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
