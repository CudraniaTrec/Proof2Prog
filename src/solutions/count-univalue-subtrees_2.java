//count-univalue-subtrees
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
class Solution {
    private boolean dfs(TreeNode root, int[] count) {
        if (root == null) {
            return true;
        }

        boolean isLeftUnival = dfs(root.left, count);
        boolean isRightUnival = dfs(root.right, count);

        if (isLeftUnival && isRightUnival &&
            (root.left == null || root.left.val == root.val) &&
            (root.right == null || root.right.val == root.val)
        ) {
            count[0]++;
            return true;
        }

        return false;
    }
    
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        dfs(root, count);
        return count[0];
    }
}