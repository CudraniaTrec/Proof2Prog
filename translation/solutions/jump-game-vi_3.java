//jump-game-vi
import java.util.List;
import java.util.LinkedList;
import java.util.Deque;
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int score = nums[0];
        Deque<int[]> dq = new LinkedList<>();
        dq.offerLast(new int[] { 0, score });
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (dq.peekFirst() != null && dq.peekFirst()[0] < i - k) {
                dq.pollFirst();
            }
            score = dq.peek()[1] + nums[i];
            // pop the smaller value
            while (dq.peekLast() != null && score >= dq.peekLast()[1]) {
                dq.pollLast();
            }
            dq.offerLast(new int[] { i, score });
        }
        return score;
    }
}