//binary-tree-postorder-traversal
import java.util.List;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;
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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> output = new LinkedList();
        Deque<TreeNode> stack = new ArrayDeque();
        
        if (root == null) return output;

        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            output.addFirst(root.val);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }

        return output;
    }
}