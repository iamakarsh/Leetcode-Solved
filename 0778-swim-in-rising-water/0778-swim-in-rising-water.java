import java.util.*;

class Solution {

    class Pair implements Comparable<Pair> {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        //@Override
        public int compareTo(Pair other) {
            return Integer.compare(this.time, other.time);
        }
    }

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));

        boolean[][] visited = new boolean[n][n];

        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            if (current.row == n - 1 && current.col == n - 1) {
                return current.time;
            }

            if (visited[current.row][current.col]) {
                continue;
            }

            visited[current.row][current.col] = true;

            for (int i = 0; i < 4; i++) {

                int newRow = current.row + directions[i][0];
                int newCol = current.col + directions[i][1];

                if (newRow < 0 || newCol < 0 || newRow >= n || newCol >= n 
                        || visited[newRow][newCol]) {
                    continue;
                }

                int newTime = Math.max(current.time, grid[newRow][newCol]);

                pq.add(new Pair(newRow, newCol, newTime));
            }
        }

        return 0;
    }
}