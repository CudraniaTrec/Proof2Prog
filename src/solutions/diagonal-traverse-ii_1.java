//diagonal-traverse-ii
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
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
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        queue.offer(new Pair(0, 0));
        List<Integer> ans = new ArrayList();
        
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            int row = p.getKey();
            int col = p.getValue();
            ans.add(nums.get(row).get(col));
            
            if (col == 0 && row + 1 < nums.size()) {
                queue.offer(new Pair(row + 1, col));
            }
            
            if (col + 1 < nums.get(row).size()) {
                queue.offer(new Pair(row, col + 1));
            }
        }
        
        // Java needs conversion
        int[] result = new int[ans.size()];
        int i = 0;
        for (int num : ans) {
            result[i] = num;
            i++;
        }
        
        return result;
    }
}