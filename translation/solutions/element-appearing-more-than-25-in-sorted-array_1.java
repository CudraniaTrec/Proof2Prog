//element-appearing-more-than-25-in-sorted-array
import java.util.Map;
import java.util.HashMap;
class Solution {
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> counts = new HashMap();
        int target = arr.length / 4;
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            if (counts.get(num) > target) {
                return num;
            }
        }

        return -1;
    }
}