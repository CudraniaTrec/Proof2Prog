//sum-root-to-leaf-numbers
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
  public int sumNumbers(TreeNode root) {
    int rootToLeaf = 0, currNumber = 0;
    Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
    stack.push(new Pair(root, 0));

    while (!stack.isEmpty()) {
      Pair<TreeNode, Integer> p = stack.pop();
      root = p.getKey();
      currNumber = p.getValue();

      if (root != null) {
        currNumber = currNumber * 10 + root.val;
        // if it's a leaf, update root-to-leaf sum
        if (root.left == null && root.right == null) {
          rootToLeaf += currNumber;
        } else {
          stack.push(new Pair(root.right, currNumber));
          stack.push(new Pair(root.left, currNumber));
        }
      }
    }
    return rootToLeaf;
  }
}