class Solution {
    class Pair {
        int city;
        int Cost;
        int stops;
        Pair(int city, int Cost, int stops) {
            this.city = city;
            this.Cost = Cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> flightGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            flightGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            int fromCity = flights[i][0];
            int toCity = flights[i][1];
            int price = flights[i][2];
            flightGraph.get(fromCity).add(new int[]{toCity, price});
        }
        int[] cheapestCost = new int[n];
        Arrays.fill(cheapestCost, Integer.MAX_VALUE);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0, 0));
        cheapestCost[src] = 0;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current.stops > k) {
                continue;
            }
            for (int i = 0; i < flightGraph.get(current.city).size(); i++) {
                int nextCity = flightGraph.get(current.city).get(i)[0];
                int flightPrice = flightGraph.get(current.city).get(i)[1];
                int newCost = current.Cost + flightPrice;
                if (newCost < cheapestCost[nextCity]) {
                    cheapestCost[nextCity] = newCost;
                    queue.add(new Pair(nextCity, newCost, current.stops + 1));
                }
            }
        }
        if (cheapestCost[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return cheapestCost[dst];
    }
}