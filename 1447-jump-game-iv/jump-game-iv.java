class Solution {
    public static int minJumps(int[] arr) {
        final int n = arr.length;
        if (n == 1) return 0;
        if (n == 2 || arr[0] == arr[n - 1]) return 1;

        final Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }

        final boolean[] vis = new boolean[n];
        final int[] q = new int[n];
        int front = 0, back = 0;

        q[back++] = 0;
        vis[0] = true;

        int ret = 0;
        while (true) {
            final int sz = back - front;
            for (int k = 0; k < sz; k++) {
                final int i = q[front++];
                if (i == n - 1) return ret;
                final int x = arr[i];
                final List<Integer> indices = mp.get(x);
                if (indices != null) {
                    for (final int j : indices) {
                        if (!vis[j]) {
                            q[back++] = j;
                            vis[j] = true;
                        }
                    }
                    mp.put(x, null);
                }
                final int l = i - 1, r = i + 1;
                if (l >= 0 && !vis[l]) {
                    q[back++] = l;
                    vis[l] = true;
                }
                if (r < n && !vis[r]) {
                    q[back++] = r;
                    vis[r] = true;
                }
            }
            ret++;
        }
    }
}