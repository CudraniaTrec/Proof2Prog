//closest-leaf-in-a-binary-tree
import java.util.Map;
import java.util.List;
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
    List<TreeNode> path;
    Map<TreeNode, LeafResult> annotation;

    public int findClosestLeaf(TreeNode root, int k) {
        path = new ArrayList();
        annotation = new HashMap();

        dfs(root, k);

        int distanceFromTarget = path.size() - 1;
        int dist = Integer.MAX_VALUE;
        TreeNode leaf = null;
        for (TreeNode node: path) {
            LeafResult lr = closestLeaf(node);
            if (lr.dist + distanceFromTarget < dist) {
                dist = lr.dist + distanceFromTarget;
                leaf = lr.node;
            }
            distanceFromTarget--;
        }
        return leaf.val;
    }

    public boolean dfs(TreeNode node, int k) {
        if (node == null) {
            return false;
        } else if (node.val == k) {
            path.add(node);
            return true;
        } else {
            path.add(node);
            boolean ans = dfs(node.left, k);
            if (ans) return true;
            ans = dfs(node.right, k);
            if (ans) return true;
            path.remove(path.size() - 1);
            return false;
        }
    }

    public LeafResult closestLeaf(TreeNode root) {
        if (root == null) {
            return new LeafResult(null, Integer.MAX_VALUE);
        } else if (root.left == null && root.right == null) {
            return new LeafResult(root, 0);
        } else if (annotation.containsKey(root)) {
            return annotation.get(root);
        } else {
            LeafResult r1 = closestLeaf(root.left);
            LeafResult r2 = closestLeaf(root.right);
            LeafResult ans = new LeafResult(r1.dist < r2.dist ? r1.node : r2.node,
                                            Math.min(r1.dist, r2.dist) + 1);
            annotation.put(root, ans);
            return ans;
        }
    }
}
class LeafResult {
    TreeNode node;
    int dist;
    LeafResult(TreeNode n, int d) {
        node = n;
        dist = d;
    }
}