class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int dist[][]= new int [n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(mat[i][j]==0){
                    dist[i][j] = 0;
                    q.add(new int[]{i, j});
                }else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int i = 0; i < dirs.length; i++) {
                int[] dir = dirs[i];
                int nr = r + dir[0];
                int nc = c + dir[1];


                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (dist[nr][nc] > dist[r][c] + 1) {
                dist[nr][nc] = dist[r][c] + 1;
                q.add(new int[]{nr, nc});
                }
            }
        }
        return dist;
    }
}