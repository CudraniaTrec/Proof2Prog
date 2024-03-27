//all-nodes-distance-k-in-binary-tree
import java.util.Map;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        dfsBuild(root, null, graph);
        
        List<Integer> answer = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        
        // Add the target node to the queue with a distance of 0
        queue.add(new int[]{target.val, 0});
        visited.add(target.val);
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], distance = cur[1];
            
            // If the current node is at distance k from target,
            // add it to the answer list and continue to the next node.
            if (distance == k) {
                answer.add(node);
                continue;
            }
            
            // Add all unvisited neighbors of the current node to the queue.
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new int[]{neighbor, distance + 1});
                }
            }
        }
        
        return answer;
    }
    
    // Recursively build the undirected graph from the given binary tree.
    private void dfsBuild(TreeNode cur, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if (cur != null && parent != null) {
            int curVal = cur.val, parentVal = parent.val;
            graph.putIfAbsent(curVal, new ArrayList<>());
            graph.putIfAbsent(parentVal, new ArrayList<>());
            graph.get(curVal).add(parentVal);
            graph.get(parentVal).add(curVal);
        }
        
        if (cur != null && cur.left != null) {
            dfsBuild(cur.left, cur, graph);
        }
        
        if (cur != null && cur.right != null) {
            dfsBuild(cur.right, cur, graph);
        }
    }
}