//closest-binary-search-tree-value-ii
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> queue = new LinkedList<>();
        dfs(root, queue, k, target);
        return new ArrayList<>(queue);
    }
    
    public void dfs(TreeNode node, Deque<Integer> queue, int k, double target) {
        if (node == null) {
            return;
        }
        
        dfs(node.left, queue, k, target);
        queue.add(node.val);
        if (queue.size() > k) {
            if (Math.abs(target - queue.peekFirst()) < Math.abs(target - queue.peekLast())) {
                queue.removeLast();
                return;
            } else {
                queue.removeFirst();
            }
        }

        dfs(node.right, queue, k, target);
    }
}