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
public TreeNode successor(TreeNode root) {
  root = root.right;
  while (root.left != null) root = root.left;
  return root;
} 
}