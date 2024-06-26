//recover-binary-search-tree
import java.util.List;
class Solution {
public int[] findTwoSwapped(List<Integer> nums) {
  int n = nums.size();
  int x = -1, y = -1;
  boolean swapped_first_occurrence = false;

  for(int i = 0; i < n - 1; ++i) {
    if (nums.get(i + 1) < nums.get(i)) {
      y = nums.get(i + 1);
      if (!swapped_first_occurrence) {
          // The first swap occurrence
          x = nums.get(i);
          swapped_first_occurrence = true;
      } else {
          // The second swap occurrence
          break;
      }
    }
  }
  return new int[]{x, y};
}
}