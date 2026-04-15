// Prefix Sum
class NumArray {
    int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            prefix[i+1] = prefix[i] + nums[i];
    }

    public int sumRange(int l, int r) {
        return prefix[r+1] - prefix[l];
    }
}