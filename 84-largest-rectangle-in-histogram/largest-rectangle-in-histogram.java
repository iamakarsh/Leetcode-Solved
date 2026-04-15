class Solution {
    public int largestRectangleArea(int[] h) {
    Stack<Integer> st = new Stack<>();
    int max = 0;

    for (int i = 0; i <= h.length; i++) {
        int height = (i == h.length) ? 0 : h[i];

        while (!st.isEmpty() && height < h[st.peek()]) {
            int ht = h[st.pop()];
            int width = st.isEmpty() ? i : i - st.peek() - 1;
            max = Math.max(max, ht * width);
        }
        st.push(i);
    }
    return max;
}
}