class Solution {
    static int[] parent;
    static int[] rank;
    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    static void union(int a,int b){
        int pa=find(a);
        int pb=find(b);
        if(pa==pb) return;
        if(rank[pa]<rank[pb]){
            parent[pa]=pb;
        }else{
            if(rank[pa]==rank[pb]) rank[pa]++;
            parent[pb]=pa;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            List<String> acc=accounts.get(i);
            for(int j=1;j<acc.size();j++){
                String email=acc.get(j);
                if(!map.containsKey(email)){
                    map.put(email,i);
                }
                else{
                    union(i,map.get(email));
                }
            }
        }
        HashMap<Integer,List<String>> merged=new HashMap<>();
        for(String email:map.keySet()){
            int parentAcc=find(map.get(email));
            merged.putIfAbsent(parentAcc,new ArrayList<>());
            merged.get(parentAcc).add(email);
        }
        List<List<String>> res=new ArrayList<>();
        for(int key:merged.keySet()){
            List<String> list=merged.get(key);
            Collections.sort(list);
            list.add(0,accounts.get(key).get(0));
            res.add(list);
        }
        return res;
    }
}