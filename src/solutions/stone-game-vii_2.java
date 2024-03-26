//stone-game-vii
import java.util.Arrays;
class Solution {
    int[] prefixSum;
    final int INF = Integer.MAX_VALUE;
    int[][] memo;

    private int findDifference(int start, int end, int[] stones) {
        if (start == end) {
            return 0;
        }
        if (memo[start][end] != INF) {
            return memo[start][end];
        }
        if (start + 1 == end)
            return Math.max(stones[start], stones[end]);

        int scoreRemoveFirst = prefixSum[end + 1] - prefixSum[start + 1];
        int scoreRemoveLast = prefixSum[end] - prefixSum[start];

        memo[start][end] = Math.max(
                scoreRemoveFirst - findDifference(start + 1, end, stones),
                scoreRemoveLast - findDifference(start, end - 1, stones));

        return memo[start][end];
    }

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        memo = new int[n][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, INF);
        }
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stones[i];
        }
        return findDifference(0, n - 1, stones);
    }
}