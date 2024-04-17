//sum-of-nodes-with-even-valued-grandparent
import java.util.List;
import java.util.Queue;
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
    int findVal(TreeNode root) {
        return root == null ? 0 : root.val;
    }
    
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int sum = 0;
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            
            // If the node value is even, then Check the four grandchildren
            // And add the value.
            if (curr.val % 2 == 0) {
                if (curr.left != null) {
                    sum += findVal(curr.left.left) + findVal(curr.left.right);
                }
                if (curr.right != null) {
                    sum += findVal(curr.right.left) + findVal(curr.right.right);
                }
            }
            
            // Add the non-null child of the current node.
            if (curr.left != null) 
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
        
        return sum;
    }
}