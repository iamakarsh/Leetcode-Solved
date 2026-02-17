class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum=0;
        List<List<Integer>> store=new ArrayList<>();
        backtracking(store,new ArrayList<>(),candidates,target,0);
        return store;
        
    }
    public void backtracking(List<List<Integer>> store,List<Integer> current,int[] candidates,int target,int start){
        if(target==0){
            store.add(new ArrayList<>(current));
            return;}
            if(target<0){
            
            return;}
        for(int i=start;i<candidates.length;i++){
            current.add(candidates[i]);
          
            backtracking(store,current,candidates,target-candidates[i],i);
            current.remove(current.size()-1);
        }
    }
}