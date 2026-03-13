class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        int low = 1;
        int high = piles[n-1];
        // for(int i = 0; i < n; i++){
        //     high = Math.max(high, piles[i]);
        // }
        int ans = high;
        while(low <= high){
            int mid = (low + high)/ 2;
            long hours = 0;
            for(int i = 0; i < n; i++){
                hours += (piles[i] + mid - 1) / mid;
            }
            if(hours <= h){
                ans = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return ans;
    }
}