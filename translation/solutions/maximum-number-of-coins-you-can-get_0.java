//maximum-number-of-coins-you-can-get
import java.util.Deque;
import java.util.Arrays;
import java.util.ArrayDeque;
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        ArrayDeque<Integer> queue = new ArrayDeque();
        for (int num : piles) {
            queue.addLast(num);
        }
        
        int ans = 0;
        while (!queue.isEmpty()) {
            queue.removeLast(); // alice
            ans += queue.removeLast(); // us
            queue.removeFirst(); // bob
        }
        
        return ans;
    }
}