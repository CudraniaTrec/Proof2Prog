//maximum-erasure-value
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int result = 0;
        int currentSum = 0;
        int k = 10001;
        boolean[] isPresent = new boolean[k];
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            // increment start until subarray has unique elements
            while (isPresent[nums[end]]) {
                isPresent[nums[start]] = false;
                currentSum -= nums[start];
                start++;
            }
            isPresent[nums[end]] = true;
            currentSum += nums[end];
            // update result with maximum sum found so far
            result = Math.max(result, currentSum);
        }
        return result;
    }
}