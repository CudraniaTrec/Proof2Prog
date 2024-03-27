//delete-node-in-a-bst
import java.util.List;
import java.util.LinkedList;
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
public LinkedList<Integer> inorder(TreeNode root, LinkedList<Integer> arr) {
  if (root == null) return arr;
  inorder(root.left, arr);
  arr.add(root.val);
  inorder(root.right, arr);
  return arr;
}  
}