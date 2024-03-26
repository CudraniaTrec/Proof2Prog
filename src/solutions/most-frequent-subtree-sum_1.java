//most-frequent-subtree-sum
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
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
class Solution {
    private HashMap<Integer, Integer> sumFreq = new HashMap<Integer, Integer>();
    private Integer maxFreq = 0;
    
    private int subtreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // Get left and right subtree's sum.
        int leftSubtreeSum = subtreeSum(root.left);
        int rightSubtreeSum = subtreeSum(root.right);

        // Use child's tree's sums to get current root's tree's sum
        int currSum = root.val + leftSubtreeSum + rightSubtreeSum;
        
        sumFreq.put(currSum, sumFreq.getOrDefault(currSum, 0) + 1);
        maxFreq = Math.max(maxFreq, sumFreq.get(currSum));
        return currSum;
    }
    
    public int[] findFrequentTreeSum(TreeNode root) {
        // Traverse on all nodes one by one, and find it's tree's sum.
        subtreeSum(root);
        
        List<Integer> ansList = new ArrayList<Integer>(); 
        for (Map.Entry<Integer, Integer> mapElement : sumFreq.entrySet()) {
            Integer sum = mapElement.getKey();
            Integer freq = mapElement.getValue();
            
            if (freq == maxFreq) {
                ansList.add(sum);
            }
        }
        
        int maxFreqSums[] = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            maxFreqSums[i] =  ansList.get(i).intValue();
        }
        
        return maxFreqSums;
    }
}