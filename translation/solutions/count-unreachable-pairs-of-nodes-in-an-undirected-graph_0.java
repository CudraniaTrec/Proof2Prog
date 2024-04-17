//count-unreachable-pairs-of-nodes-in-an-undirected-graph
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
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
    public int dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visit) {
        int count = 1;
        visit[node] = true;
        if (!adj.containsKey(node)) {
            return count;
        }
        for (int neighbor : adj.get(node)) {
            if (!visit[neighbor]) {
                count += dfs(neighbor, adj, visit);
            }
        }
        return count;
    }

    public long countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }

        long numberOfPairs = 0;
        long sizeOfComponent = 0;
        long remainingNodes = n;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                sizeOfComponent = dfs(i, adj, visit);
                numberOfPairs += sizeOfComponent * (remainingNodes - sizeOfComponent);
                remainingNodes -= sizeOfComponent;
            }
        }
        return numberOfPairs;
    }
}