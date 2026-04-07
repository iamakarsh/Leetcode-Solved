class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i = n - 2; i >= 0; i--){ // Start from second last row
            for(int j = 0; j <= i; j++){
                int down = triangle.get(i+1).get(j);
                int diagonal = triangle.get(i+1).get(j+1);

                int val = triangle.get(i).get(j);
                triangle.get(i).set(j, val + Math.min(down, diagonal));
                //current = value + min(down, diagonal)
            }
        }
        return triangle.get(0).get(0);
    }
}