import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> qp = new ArrayDeque<>();
        Queue<int[]> qa = new ArrayDeque<>();

        // Pacific: top row + left col
        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            qp.offer(new int[]{i, 0});
        }
        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            qp.offer(new int[]{0, j});
        }

        // Atlantic: bottom row + right col
        for (int i = 0; i < m; i++) {
            atlantic[i][n - 1] = true;
            qa.offer(new int[]{i, n - 1});
        }
        for (int j = 0; j < n; j++) {
            atlantic[m - 1][j] = true;
            qa.offer(new int[]{m - 1, j});
        }

        bfs(heights, pacific, qp);
        bfs(heights, atlantic, qa);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void bfs(int[][] heights, boolean[][] visited, Queue<int[]> q) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (heights[nr][nc] < heights[r][c]) continue;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}