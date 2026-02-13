class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int peri = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    peri += 4;

                    //up
                    if (i > 0 && grid[i - 1][j] == 1)
                        peri--;

                    //down
                    if (i < n - 1 && grid[i + 1][j] == 1)
                        peri--;

                    //left
                    if (j > 0 && grid[i][j - 1] == 1)
                        peri--;

                    //right
                    if (j < m - 1 && grid[i][j + 1] == 1)
                        peri--;
                }
            }
        }
        return peri;
    }
}
