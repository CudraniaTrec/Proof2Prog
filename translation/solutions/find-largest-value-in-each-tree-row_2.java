//find-largest-value-in-each-tree-row
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
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
class Pair<T, U> {
    T key;
    U value;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public U getValue() {
        return value;
    }
}
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        
        List<Integer> ans = new ArrayList<>();
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 0));
        
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();
            
            if (depth == ans.size()) {
                ans.add(node.val);
            } else {
                ans.set(depth, Math.max(ans.get(depth), node.val));
            }
            
            if (node.left != null) {
                stack.push(new Pair<>(node.left, depth + 1));
            }
            
            if (node.right != null) {
                stack.push(new Pair<>(node.right, depth + 1));
            }
        }
        
        return ans;
    }
}