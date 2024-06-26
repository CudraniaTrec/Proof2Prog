//element-appearing-more-than-25-in-sorted-array
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
class Solution {
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> counts = new HashMap();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        int target = arr.length / 4;
        for (int key : counts.keySet()) {
            if (counts.get(key) > target) {
                return key;
            }
        }
        
        return -1;
    }
}