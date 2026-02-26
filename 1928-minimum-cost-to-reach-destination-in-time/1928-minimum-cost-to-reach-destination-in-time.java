class Solution {
    class Node {
        int cost;
        int city;
        int time;
        Node(int cost, int city, int time) {
            this.cost = cost;
            this.city = city;
            this.time = time;
        }
    }
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int travelTime = edges[i][2];
            adj.get(u).add(new int[]{v, travelTime});
            adj.get(v).add(new int[]{u, travelTime});
        }
        int[][] dist = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Node> pq =new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Node(passingFees[0], 0, 0));
        dist[0][0] = passingFees[0];
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int cost = curr.cost;
            int city = curr.city;
            int time = curr.time;
            if (city == n - 1) {
                return cost;
            }
            for (int i = 0; i < adj.get(city).size(); i++) {
                int[] neighbor = adj.get(city).get(i);
                int nextCity = neighbor[0];
                int travelTime = neighbor[1];
                int newTime = time + travelTime;
                if (newTime > maxTime) {
                    continue;
                }
                int newCost = cost + passingFees[nextCity];
                if (newCost < dist[nextCity][newTime]) {
                    dist[nextCity][newTime] = newCost;
                    pq.add(new Node(newCost, nextCity, newTime));
                }
            }
        }
        return -1;
    }
}