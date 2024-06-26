//find-the-smallest-divisor-given-a-threshold
class Solution {
    // Return the sum of division results with 'divisor'.
    private int findDivisionSum(int[] nums, int divisor) {
        int result = 0;
        for (int num : nums) {
            result += Math.ceil((1.0 * num) / divisor);
        }
        return result;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        int ans = -1;
        
        int low = 1;
        int high = nums[0];
        for (int num : nums) {
            high = Math.max(high, num);
        }
        
        // Iterate using binary search on all divisors.
        while (low <= high) {
            int mid = (low + high) / 2;
            int result = findDivisionSum(nums, mid);
            // If current divisor does not exceed threshold, 
            // then it can be our answer, but also try smaller divisors
            // thus change search space to left half.
            if (result <= threshold) {
                ans = mid;
                high = mid - 1;
            }
            // Otherwise, we need a bigger divisor to reduce the result sum
            // thus change search space to right half.
            else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
}