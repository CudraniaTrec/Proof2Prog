//jump-game-vi
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] tree = new int[2 * n];
        update(0, nums[0], tree, n);
        for (int i = 1; i < n; i++) {
            int maxi = query(Math.max(0, i - k), i, tree, n);
            update(i, maxi + nums[i], tree, n);
        }
        return tree[2 * n - 1];
    }

    // implement Segment Tree
    private void update(int index, int value, int[] tree, int n) {
        index += n;
        tree[index] = value;
        for (index >>= 1; index > 0; index >>= 1) {
            tree[index] = Math.max(tree[index << 1], tree[(index << 1) + 1]);
        }
    }

    private int query(int left, int right, int[] tree, int n) {
        int result = Integer.MIN_VALUE;
        for (left += n, right += n; left < right; left >>= 1, right >>= 1) {
            if ((left & 1) == 1) {
                result = Math.max(result, tree[left++]);
            }
            if ((right & 1) == 1) {
                result = Math.max(result, tree[--right]);
            }
        }
        return result;
    }
}