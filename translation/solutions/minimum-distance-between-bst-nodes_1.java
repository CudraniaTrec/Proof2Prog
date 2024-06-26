//minimum-distance-between-bst-nodes
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
  int minDistance = Integer.MAX_VALUE;
  // Initially, it will be null.
  TreeNode prevValue;

  void inorderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }

    inorderTraversal(root.left);

    // Find the difference with the previous value if it is there.
    if (prevValue != null) {
      minDistance = Math.min(minDistance, root.val - prevValue.val);
    }
    prevValue = root;

    inorderTraversal(root.right);
  }

  public int minDiffInBST(TreeNode root) {
    inorderTraversal(root);

    return minDistance;
  }
};