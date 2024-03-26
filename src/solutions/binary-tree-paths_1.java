//binary-tree-paths
import java.util.List;
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
  public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
    if (root != null) {
      path += Integer.toString(root.val);
      if ((root.left == null) && (root.right == null))  // if reach a leaf
        paths.add(path);  // update paths
      else {
        path += "->";  // extend the current path
        construct_paths(root.left, path, paths);
        construct_paths(root.right, path, paths);
      }
    }
  }

  public List<String> binaryTreePaths(TreeNode root) {
    LinkedList<String> paths = new LinkedList();
    construct_paths(root, "", paths);
    return paths;
  }
}