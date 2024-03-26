//closest-binary-search-tree-value
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
  public int closestValue(TreeNode root, double target) {
    LinkedList<TreeNode> stack = new LinkedList();
    long pred = Long.MIN_VALUE;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      root = stack.removeLast();

      if (pred <= target && target < root.val)
        return Math.abs(pred - target) < Math.abs(root.val - target) ? (int)pred : root.val;

      pred = root.val;
      root = root.right;
    }
    return (int)pred;
  }
}