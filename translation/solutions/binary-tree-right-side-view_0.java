//binary-tree-right-side-view
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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque() {{ offer(root); }};
        ArrayDeque<TreeNode> currLevel = new ArrayDeque();        
        List<Integer> rightside = new ArrayList();
        
        TreeNode node = null;
        while (!nextLevel.isEmpty()) {
            // prepare for the next level
            currLevel = nextLevel;
            nextLevel = new ArrayDeque<>();

            while (! currLevel.isEmpty()) {
                node = currLevel.poll();

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) 
                    nextLevel.offer(node.left);    
                if (node.right != null) 
                    nextLevel.offer(node.right);
            }
            
            // The current level is finished.
            // Its last element is the rightmost one.
            if (currLevel.isEmpty()) 
                rightside.add(node.val);    
        }
        return rightside;
    }
}