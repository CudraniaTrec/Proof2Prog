//find-right-interval
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
class Solution {

  public int[] binary_search(int[][] intervals, int target, int start, int end) {
    if (start >= end) {
      if (intervals[start][0] >= target) {
        return intervals[start];
      }
      return null;
    }
    int mid = (start + end) / 2;
    if (intervals[mid][0] < target) {
      return binary_search(intervals, target, mid + 1, end);
    } else {
      return binary_search(intervals, target, start, mid);
    }
  }

  public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        HashMap<int[], Integer> hash = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            hash.put(intervals[i], i);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = binary_search(intervals, intervals[i][1], 0, intervals.length - 1);
            res[hash.get(intervals[i])] = interval == null ? -1 : hash.get(interval);
        }
        return res;
    }
}