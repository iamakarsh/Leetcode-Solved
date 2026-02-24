class Solution {
     class Pair {
        int row;
        int col;
        int effort;
        Pair(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int totalRows = heights.length;
        int totalCols = heights[0].length;
        int[][] minimumEffort = new int[totalRows][totalCols];
        for (int i = 0; i < totalRows; i++) {
            Arrays.fill(minimumEffort[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
                (a, b) -> a.effort - b.effort
        );

        minHeap.add(new Pair(0, 0, 0));
        minimumEffort[0][0] = 0;
        int[] rowDirection = {1, -1, 0, 0};
        int[] colDirection = {0, 0, 1, -1};
        while (!minHeap.isEmpty()) {
            Pair current = minHeap.poll();
            if (current.row == totalRows - 1 && current.col == totalCols - 1) {
                return current.effort;
            }
            for (int i = 0; i < 4; i++) {
                int newRow = current.row + rowDirection[i];
                int newCol = current.col + colDirection[i];
                if (newRow >= 0 && newCol >= 0 && newRow < totalRows && newCol < totalCols) {
                    int heightDifference = Math.abs(
                            heights[current.row][current.col] - heights[newRow][newCol]
                    );
                    int newEffort = Math.max(current.effort, heightDifference);
                    if (newEffort < minimumEffort[newRow][newCol]) {
                        minimumEffort[newRow][newCol] = newEffort;
                        minHeap.add(new Pair(newRow, newCol, newEffort));
                    }
                }
            }
        }
        return 0;
    }
}