//find-mode-in-binary-search-tree
import java.util.Map;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> counter = new HashMap();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            
            counter.put(node.val, counter.getOrDefault(node.val, 0) + 1);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        
        int maxFreq = 0;
        for (int key : counter.keySet()) {
            maxFreq = Math.max(maxFreq, counter.get(key));
        }
        
        List<Integer> ans = new ArrayList();
        for (int key : counter.keySet()) {
            if (counter.get(key) == maxFreq) {
                ans.add(key);
            }
        }
        
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        
        return result;
    }
}