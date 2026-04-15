class Solution {
    public int[] twoSum(int[] arr, int target) {
    int l = 0, r = arr.length-1;
    while (l < r) {
        int sum = arr[l] + arr[r];
        if (sum == target) return new int[]{l+1, r+1};
        else if (sum < target) l++;
        else r--;
    }
    return new int[]{};
}
}