//maximum-erasure-value
import java.util.Set;
import java.util.HashSet;
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int result = 0;
        int currentSum = 0;
        HashSet<Integer> set = new HashSet<>();
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            // increment start until subarray has unique elements
            while (set.contains(nums[end])) {
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
            currentSum += nums[end];
            set.add(nums[end]);
            // update result with maximum sum found so far
            result = Math.max(result, currentSum);
        }
        return result;
    }
}