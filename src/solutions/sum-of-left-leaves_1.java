//sum-of-left-leaves
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
    
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return processSubtree(root, false);
  }
    
  private int processSubtree(TreeNode subtree, boolean isLeft) {
        
    // Base case: This is a leaf node.
    if (subtree.left == null && subtree.right == null) {
      return isLeft ? subtree.val : 0;
    }
        
    // Recursive case: We need to add and return the results of the
    // left and right subtrees.
    int total = 0;
    if (subtree.left != null) {
      total += processSubtree(subtree.left, true);
    }
    if (subtree.right != null) {
      total += processSubtree(subtree.right, false);
    }
    return total;
  }
}