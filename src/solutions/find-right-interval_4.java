//find-right-interval
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
class Solution {

  public int[] findRightInterval(int[][] intervals) {
    int[][] endIntervals = Arrays.copyOf(intervals, intervals.length);
    HashMap<int[], Integer> hash = new HashMap<>();
    for (int i = 0; i < intervals.length; i++) {
      hash.put(intervals[i], i);
    }
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    Arrays.sort(endIntervals, (a, b) -> a[1] - b[1]);
    int j = 0;
    int[] res = new int[intervals.length];
    for (int i = 0; i < endIntervals.length; i++) {
      while (j < intervals.length && intervals[j][0] < endIntervals[i][1]) {
        j++;
      }
      res[hash.get(endIntervals[i])] = j == intervals.length ? -1 : hash.get(intervals[j]);
    }
    return res;
  }
}
