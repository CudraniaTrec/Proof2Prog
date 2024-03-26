//validate-binary-tree-nodes
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
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
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1) {
            return false;
        }
        
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        seen.add(root);
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int node = queue.remove();
            int[] children = {leftChild[node], rightChild[node]};
            
            for (int child : children) {
                if (child != -1) {
                    if (seen.contains(child)) {
                        return false;
                    }
                    
                    queue.add(child);
                    seen.add(child);
                }
            }
            
        }
        
        return seen.size() == n;
    }
    
    public int findRoot(int n, int[] left, int[] right) {
        Set<Integer> children = new HashSet<>();
        for (int node : left) {
            children.add(node);
        }
        
        for (int node : right) {
            children.add(node);
        }
        
        for (int i = 0; i < n; i++) {
            if (!children.contains(i)) {
                return i;
            }
        }
        
        return -1;
    }
}