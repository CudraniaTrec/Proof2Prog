//delete-node-in-a-bst
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
public TreeNode predecessor(TreeNode root) {
  root = root.left;
  while (root.right != null) root = root.right;
  return root;
} 
}