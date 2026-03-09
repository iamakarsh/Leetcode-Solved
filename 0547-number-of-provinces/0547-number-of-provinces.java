class Solution {

    class DSU{
        int parent[];

        DSU(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa != pb){
                parent[pb] = pa;
            }
        }

        public int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        DSU obj = new DSU(n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                if(isConnected[i][j] == 1){
                    obj.union(i, j);
                }

            }
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            if(obj.find(i) == i)
                count++;
        }

        return count;
    }
}