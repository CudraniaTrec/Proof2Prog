//find-mode-in-binary-search-tree
import java.util.List;
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
    int maxStreak = 0;
    int currStreak = 0;
    int currNum = 0;
    List<Integer> ans = new ArrayList();
    
    public void add(int num) {
        if (num == currNum) {
            currStreak++;
        } else {
            currStreak = 1;
            currNum = num;
        }

        if (currStreak > maxStreak) {
            ans = new ArrayList();
            maxStreak = currStreak;
        }

        if (currStreak == maxStreak) {
            ans.add(num);
        }
    }

    public int[] findMode(TreeNode root) {
        TreeNode curr = root;
        TreeNode friend;
        while (curr != null) {
            if (curr.left != null) {
                friend = curr.left;
                while (friend.right != null && friend.right != curr) {
                    friend = friend.right;
                }
                
                if (friend.right == null) {
                    friend.right = curr;
                    curr = curr.left;
                } else {
                    friend.right = null;
                    add(curr.val);
                    curr = curr.right;
                }
                
            } else {
                add(curr.val);
                curr = curr.right;
            }
        }
        
        
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        
        return result;
    }
}