class Solution {

    class Pair {
        int pr, pc;
        int cr, cc;

        Pair(int pr, int pc, int cr, int cc) {
            this.pr = pr;
            this.pc = pc;
            this.cr = cr;
            this.cc = cc;
        }
    }

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    if (bfs(i, j, n, m, grid, vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean bfs(int i, int j, int n, int m, char[][] grid, boolean[][] vis) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(-1, -1, i, j));
        vis[i][j] = true;

        while (!q.isEmpty()) {
            Pair temp = q.remove();
            int pr = temp.pr, pc = temp.pc;
            int cr = temp.cr, cc = temp.cc;

            for (int x = 0; x < 4; x++) {
                int nr = cr + dr[x];
                int nc = cc + dc[x];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    grid[nr][nc] == grid[cr][cc]) {

                    if (vis[nr][nc]) {
                        if (pr != nr || pc != nc) {
                            return true;  
                        }
                    } else {
                        vis[nr][nc] = true;
                        q.add(new Pair(cr, cc, nr, nc));
                    }
                }
            }
        }
        return false;
    }
}
