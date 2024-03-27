//maximum-product-of-two-elements-in-an-array
import java.util.Arrays;
class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int x = nums[nums.length - 1];
        int y = nums[nums.length - 2];
        return (x - 1) * (y - 1);
    }
}