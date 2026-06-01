class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            int num=nums[i];
            pq.add(num);
        }
        while(k>1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}