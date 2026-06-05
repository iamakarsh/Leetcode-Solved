class Solution {
    int max=0;
    public int maxLevelSum(TreeNode root) {
        return maxSum(root,Integer.MIN_VALUE,0);
    }
    public int maxSum(TreeNode root,int max,int c){
       if(root==null) return 0 ;
       Queue<TreeNode> q= new LinkedList<>();
       q.add(root);
       q.add(null);
       int sum=0,count=0;
       while(!q.isEmpty()){
          TreeNode curr= q.remove();
          if(curr==null){
             count++;
             if(sum>max){
                max=sum;
                c=count;
             }
             if(q.isEmpty()){
                break;
             }
             else{
                q.add(null);
             }
             sum=0;
          }
          else{
             sum+=curr.val;
            if(curr.left!=null)
                 q.add(curr.left);
            if(curr.right!=null)
                 q.add(curr.right);
          }
       }
       return c;
    }
}