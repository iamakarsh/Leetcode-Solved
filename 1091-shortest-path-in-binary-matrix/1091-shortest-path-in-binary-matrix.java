class Solution { 
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    int[] rowD = {-1,-1,-1,0,0,1,1,1};
    int[] colD = {-1,0,1,-1,1,-1,0,1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        int[][] dist = new int[n][n];
        dist[0][0] = 1;
        grid[0][0] = 1;  //visited
        
        while(!q.isEmpty()) {
            
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            
            if(r == n-1 && c == n-1)
                return dist[r][c];
            
            for(int i = 0; i < 8; i++) {
                
                int nr = r + rowD[i];
                int nc = c + colD[i];
                
                if(nr >= 0 && nc >= 0 && nr < n && nc < n
                   && grid[nr][nc] == 0) {
                    
                    q.add(new Pair(nr, nc));
                    dist[nr][nc] = dist[r][c] + 1;
                    grid[nr][nc] = 1;  // mark visited
                }
            }
        }
        return -1;
    }
}