//minimize-maximum-pair-sum-in-array
import java.util.Arrays;
class Pair<T, U> {
    T key;
    U value;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public U getValue() {
        return value;
    }
}
class Solution {
  public int minPairSum(int[] nums) {
    Arrays.sort(nums);

    int maxSum = 0;
    for (int i = 0; i < nums.length / 2; i++) {
      maxSum = Math.max(maxSum, nums[i] + nums[nums.length - 1 - i]);
    }

    return maxSum;

  }
}