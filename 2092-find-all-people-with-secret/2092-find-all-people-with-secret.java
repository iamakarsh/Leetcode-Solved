class Solution {static int[] parent;
    static int[] rank;
    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    static boolean union(int a,int b){
        int pa=find(a);
        int pb=find(b);
        if(pa==pb) return false;
        if(rank[pa]<rank[pb]){
            parent[pa]=pb;
        }else if(rank[pa]>rank[pb]){
            parent[pb]=pa;
        }else{
            parent[pb]=pa;
            rank[pa]++;
        }
        return true; 
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
         parent=new int[n];
         rank=new int[n];
        //boolean new= new boolean[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        union(0,firstPerson);
        Arrays.sort(meetings,(a,b)->(a[2]-b[2]));
        int i=0;
        while(i<meetings.length){
            int time=meetings[i][2];
            List<int[]>group=new ArrayList<>();
            while(i<meetings.length && meetings[i][2]==time){
                group.add(meetings[i]);
                union(meetings[i][0],meetings[i][1]);
                i++;
            }
            for(int[]m:group){
                int a=m[0];
                int b=m[1];
                if(find(a)!=find(0)){
                    parent[a]=a;
                    parent[b]=b;
                }
            }
            
        }
        List<Integer> ans=new ArrayList<>();
        for(int j=0;j<n;j++){
            if(find(j)==find(0)) ans.add(j);
        } 
        return ans; 
    }
}