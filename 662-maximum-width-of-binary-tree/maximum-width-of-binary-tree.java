class Solution {
    class Pair {
        TreeNode node;
        long idx;
        Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int maxWidth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            long minIdx = q.peek().idx; 
            long first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                long idx = curr.idx - minIdx;
                if (i == 0) first = idx;
                if (i == size - 1) last = idx;
                if (curr.node.left != null) {
                    q.add(new Pair(curr.node.left, 2 * idx + 1));
                }
                if (curr.node.right != null) {
                    q.add(new Pair(curr.node.right, 2 * idx + 2));
                }
            }
            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }
        return maxWidth;
    }
}