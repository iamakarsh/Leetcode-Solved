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

    public void bfs(char[][] board, int row, int col, boolean[][] vis) {
        int n = board.length;
        int m = board[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.row + dr[i];
                int nc = cur.col + dc[i];

                if (isValid(nr, nc, n, m) &&
                    board[nr][nc] == 'O' &&
                    !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        // first row
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O' && !vis[0][i]) {
                bfs(board, 0, i, vis);
            }
        }

        // last row
        for (int i = 0; i < m; i++) {
            if (board[n - 1][i] == 'O' && !vis[n - 1][i]) {
                bfs(board, n - 1, i, vis);
            }
        }

        // first column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                bfs(board, i, 0, vis);
            }
        }

        // last column
        for (int i = 0; i < n; i++) {
            if (board[i][m - 1] == 'O' && !vis[i][m - 1]) {
                bfs(board, i, m - 1, vis);
            }
        }

        // flip suround O
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
