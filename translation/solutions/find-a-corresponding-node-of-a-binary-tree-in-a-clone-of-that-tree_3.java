//find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree
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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> stack_o = new ArrayDeque();
        Deque<TreeNode> stack_c = new ArrayDeque();
        TreeNode node_o = original, node_c = cloned;

        while (!stack_o.isEmpty() || node_o != null) {
            while (node_o != null) {
                stack_o.add(node_o);
                stack_c.add(node_c);

                node_o = node_o.left;
                node_c = node_c.left;
            }
            node_o = stack_o.removeLast();
            node_c = stack_c.removeLast();
            if (node_o == target) {
                return node_c;
            }
            node_o = node_o.right;
            node_c = node_c.right;
        }
        return null;
    }
}