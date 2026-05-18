class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public boolean isValid(int row, int col, int totalRows, int totalCols) {
        if (row >= 0 && row < totalRows && col >= 0 && col < totalCols)
            return true;
        return false;
    }

    int rowDirection[] = {1, -1, 0, 0};
    int colDirection[] = {0, 0, 1, -1};

    public void bfs(int[][] image, boolean[][] isVisited,int currRow, int currCol,int totalRows, int totalCols,int originalColor, int newColor) {
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(currRow, currCol);
        q.add(p);
        isVisited[currRow][currCol] = true;
        image[currRow][currCol] = newColor;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int currPairRow = curr.row;
            int currPairCol = curr.col;
            for (int i = 0; i < 4; i++) {
                int newRow = currPairRow + rowDirection[i];
                int newCol = currPairCol + colDirection[i];
                if (isValid(newRow, newCol, totalRows, totalCols)&& !isVisited[newRow][newCol] && image[newRow][newCol] == originalColor) {
                    isVisited[newRow][newCol] = true;
                    image[newRow][newCol] = newColor;
                    Pair temp = new Pair(newRow, newCol);
                    q.add(temp);
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int originalColor = image[sr][sc];
        if (originalColor == color) return image;
        boolean[][] isVisited = new boolean[n][m];
        bfs(image, isVisited, sr, sc, n, m, originalColor, color);
        return image;
    }
}
