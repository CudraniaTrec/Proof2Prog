//binary-tree-postorder-traversal
import java.util.List;
import java.util.ArrayList;
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
        List<Integer> output = new ArrayList();
        Deque<TreeNode> stack = new ArrayDeque();
        
        while (root != null || !stack.isEmpty()) {
            // push nodes: right -> node -> left
            while (root != null) {
                if (root.right != null) {
                    stack.push(root.right);    
                }
                stack.push(root);
                root = root.left;    
            }
            
            root = stack.pop();
            
            // if the right subtree is not yet processed
            if (!stack.isEmpty() && root.right == stack.peek()) {
                stack.pop();
                stack.push(root);
                root = root.right;  
            // if we're on the leftmost leaf  
            } else {
                output.add(root.val);
                root = null;     
            }   
        }

        return output;
    }
}