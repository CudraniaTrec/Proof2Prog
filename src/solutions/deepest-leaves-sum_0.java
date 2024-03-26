//deepest-leaves-sum
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
  public int deepestLeavesSum(TreeNode root) {
    int deepestSum = 0, depth = 0, currDepth;
    Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
    stack.push(new Pair(root, 0));

    while (!stack.isEmpty()) {
      Pair<TreeNode, Integer> p = stack.pop();
      root = p.getKey();
      currDepth = p.getValue();

      if (root.left == null && root.right == null) {
        // if this leaf is the deepest one seen so far
        if (depth < currDepth) {
          deepestSum = root.val;      // start new sum
          depth = currDepth;          // note new depth    
        } else if (depth == currDepth) {
          // if there were already leaves at this depth
          deepestSum += root.val;     // update existing sum    
        }
      } else {
        if (root.right != null) {
          stack.push(new Pair(root.right, currDepth + 1));
        }
        if (root.left != null) {
          stack.push(new Pair(root.left, currDepth + 1));
        }
      }
    }
    return deepestSum;
  }
}