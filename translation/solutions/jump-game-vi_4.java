//jump-game-vi
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.PriorityQueue;
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int score = nums[0];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        priorityQueue.add(new int[] { nums[0], 0 });
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (priorityQueue.peek()[1] < i - k) {
                priorityQueue.remove();
            }
            score = nums[i] + priorityQueue.peek()[0];
            priorityQueue.add(new int[] { score, i });
        }
        return score;
    }
}