//check-array-formation-through-concatenation
import java.util.Map;
import java.util.HashMap;
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        // initialize hashmap
        Map<Integer, int[]> mapping = new HashMap<>();
        for (int[] p : pieces) {
            mapping.put(p[0], p);
        }

        int i = 0;
        while (i < n) {
            // find target piece
            if (!mapping.containsKey(arr[i])) {
                return false;
            }
            // check target piece
            int[] targetPiece = mapping.get(arr[i]);
            for (int x : targetPiece) {
                if (x != arr[i]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}