//n-ary-tree-preorder-traversal
import java.util.List;
// Definition for a Node.
class Node {
  public int val;
  public List<Node> children;

  public Node() {}

  public Node(int _val,List<Node> _children) {
    val = _val;
    children = _children;
  }
};