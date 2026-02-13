class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int minutes = -1;
        int[][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1} };

        while (!q.isEmpty()) {
            int size = q.size();
            minutes++;

            for (int s = 0; s < size; s++) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];

                for (int i=0;i<dirs.length;i++) {
                    int dir[]=dirs[i];
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && nx < n &&
                        ny >= 0 && ny < m &&
                        grid[nx][ny] == 1) {

                        grid[nx][ny] = 2;
                        fresh--;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        if (fresh == 0)
            return minutes;
        return -1;

    }
}
