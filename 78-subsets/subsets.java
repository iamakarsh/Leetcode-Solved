class Solution {
    public void solve(int nums[],int i,List<List<Integer>> ans,List<Integer>curr){
        if(i>=nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        solve(nums,i+1,ans,curr);
        curr.remove(curr.size()-1);
        solve(nums,i+1,ans,curr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        solve(nums,0,ans,curr);
        return ans;
    }
}