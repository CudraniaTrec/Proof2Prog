//insert-into-a-binary-search-tree
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
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);

    // insert into the right subtree
    if (val > root.val) root.right = insertIntoBST(root.right, val);
    // insert into the left subtree
    else root.left = insertIntoBST(root.left, val);
    return root;
  }
}