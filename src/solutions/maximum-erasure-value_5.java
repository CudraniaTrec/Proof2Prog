//maximum-erasure-value
import java.util.Arrays;
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length, k = 10001;
        int[] lastIndexes = new int[k];
        int[] prefixSum = new int[n + 1];
        // initialize last indexes to -1
        Arrays.fill(lastIndexes, -1);
        int result = 0, start = 0;
        for (int end = 0; end < n; end++) {
            int currentElement = nums[end];
            prefixSum[end + 1] = prefixSum[end] + currentElement;
            if (lastIndexes[currentElement] != -1) {
                start = Math.max(start, lastIndexes[currentElement] + 1);
            }
            // update result with maximum sum found so far
            result = Math.max(result, prefixSum[end + 1] - prefixSum[start]);
            // update last index of current element
            lastIndexes[currentElement] = end;
        }
        return result;
    }
}