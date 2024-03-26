//check-if-a-number-is-majority-element-in-a-sorted-array
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            count = num == target ? count + 1 : count;
        }
        
        return count > nums.length / 2;
    }
}