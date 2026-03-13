class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=1;
        int high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,weights[i]);
            high+=weights[i];
        }
        int ans=0;
        while(low<=high){
           int mid=(low+high)/2;
           if(canCarry(weights,days,mid)){
            ans=mid;
            high=mid-1;
           }
           else{
            low=mid+1;
           }
        }
        return ans; 
    }
    public boolean canCarry(int[] weights,int days,int capacity){
        int currWeight=0;
        int countday=1;
        for(int w:weights){
            if(currWeight+w>capacity){
                countday++;
                currWeight=0;
            }
            currWeight+=w;
        }
        return countday<=days;

    }
}