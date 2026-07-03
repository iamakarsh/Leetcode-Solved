class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        int high = -1;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v, w});
            high = Math.max(high, w);
        }

        int low = 0, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(graph, online, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(List<List<int[]>> graph, boolean[] online, long mid, long k) {
        int n = graph.size();
        long[] cost = new long[n];
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long currCost = top[0];
            int node = (int) top[1];

            if (currCost > cost[node]) continue;
            if (node != 0 && node != n - 1 && !online[node]) continue;

            for (int[] edge : graph.get(node)) {
                int adj = edge[0];
                int wt = edge[1];

                if (wt < mid) continue;
                if (adj != 0 && adj != n - 1 && !online[adj]) continue;

                long newCost = currCost + wt;
                if (newCost > k) continue;

                if (newCost < cost[adj]) {
                    cost[adj] = newCost;
                    pq.offer(new long[]{newCost, adj});
                }
            }
        }

        return cost[n - 1] <= k;
    }
}