class Solution {
    static int[] parent;
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
    boolean similar(String a,String b){
        int diff=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
                if(diff>2) return false;
            }
        }
        return diff==0 || diff==2;
    }
    public int numSimilarGroups(String[] strs) {
        int n=strs.length;
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        int group=n;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(similar(strs[i],strs[j])){
                    if(union(i,j)) group--;
                }
            }
        }
        return group;
    }
}