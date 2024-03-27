//minimum-moves-to-equal-array-elements-ii
class Solution {
    public int minMoves2(int[] nums) {
        long ans = Long.MAX_VALUE;
        int minval = Integer.MAX_VALUE;
        int maxval = Integer.MIN_VALUE;
        for (int num : nums) {
            minval = Math.min(minval, num);
            maxval = Math.max(maxval, num);
        }
        for (int i = minval; i <= maxval; i++) {
            long sum = 0;
            for (int num : nums) {
                sum += Math.abs(num - i);
            }
            ans = Math.min(ans, sum);
        }
        return (int) ans;
    }
}