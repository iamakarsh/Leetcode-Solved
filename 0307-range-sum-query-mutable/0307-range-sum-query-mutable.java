// class NumArray {

//     int[] tree;
//     int n;
//     public NumArray(int[] nums) {
//         n = nums.length;
//         tree = new int[4 * n];    
//         build(nums, 0, 0, n - 1);
//     }
//     void build(int[] nums, int node, int start, int end) {
//         if (start == end) {
//             tree[node] = nums[start];
//             return;
//         }
//         int mid = start + (end - start) / 2;
//         build(nums, 2 * node + 1, start, mid);
//         build(nums, 2 * node + 2, mid + 1, end);
//         tree[node] = tree[2* node + 1] + tree[2 * node + 2];
//     }
//     public void update(int index, int val) {
//         updateUtil(0, 0, n - 1, index, val);
//     }
//     void updateUtil(int node, int start, int end, int idx, int val) {
//         if (start == end) {
//             tree[node] = val;
//             return;
//         }
//         int mid = start + (end - start) / 2;
//         if (idx <= mid)
//             updateUtil(2 * node + 1, start, mid, idx, val);
//         else
//             updateUtil(2 * node + 2, mid + 1, end, idx, val);

//         tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
//     }
//     public int sumRange(int left, int right) {
//         return query(0, 0, n - 1, left, right);
//     }
//     int query(int node, int start, int end, int l, int r) {
//         if (r < start || end < l)
//             return 0;
//         if (l <= start && end <= r)
//             return tree[node];
//         int mid = start + (end - start) / 2;
//         int leftSum = query(2 * node + 1, start, mid, l, r);
//         int rightSum = query(2 * node + 2, mid + 1, end, l, r);
//         return leftSum + rightSum;
//     }
// }
class NumArray {

    int[] tree, lazy;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        lazy = new int[4 * n];
        build(nums, 0, 0, n - 1);
    }

    void build(int[] nums, int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }

        int mid = (start + end) / 2;

        build(nums, 2 * node + 1, start, mid);
        build(nums, 2 * node + 2, mid + 1, end);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    
    public void update(int index, int val) {
        int curr = sumRange(index, index);
        int diff = val - curr;
        updateUtil(0, 0, n - 1, index, index, diff);
    }


    void updateUtil(int node, int start, int end, int l, int r, int val) {

       
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            lazy[node] = 0;
        }

      
        if (r < start || end < l) return;

  
        if (l <= start && end <= r) {
            tree[node] += (end - start + 1) * val;
            if (start != end) {
                lazy[2 * node + 1] += val;
                lazy[2 * node + 2] += val;
            }
            return;
        }

        int mid = (start + end) / 2;

        updateUtil(2 * node + 1, start, mid, l, r, val);
        updateUtil(2 * node + 2, mid + 1, end, l, r, val);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    int query(int node, int start, int end, int l, int r) {

        // INLINE PUSH
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            lazy[node] = 0;
        }

        if (r < start || end < l) return 0;

        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;

        return query(2 * node + 1, start, mid, l, r) +
               query(2 * node + 2, mid + 1, end, l, r);
    }
}