class Solution {
    public int lastStoneWeight(int[] stones) {
        int n=stones.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            int stone=stones[i];
            pq.add(stone);
        }
        while(pq.size()>1){
            int y=pq.poll();
            int x=pq.poll();
            if(y!=x){
                pq.add(y-x);
            }
        }
        if(pq.isEmpty()){
            return 0;
        }else{
            return pq.peek();
        }
    }
}