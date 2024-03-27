//stone-game-vii
import java.util.Arrays;
class Solution {
    int[] prefixSum;
    final int INF = Integer.MAX_VALUE;
    int[][] memo;

    private int findDifference(int start, int end, boolean alice) {
        if (start == end) {
            return 0;
        }
        if (memo[start][end] != INF) {
            return memo[start][end];
        }
        int difference;
        int scoreRemoveFirst = prefixSum[end + 1] - prefixSum[start + 1];
        int scoreRemoveLast = prefixSum[end] - prefixSum[start];

        if (alice) {
            difference = Math.max(
                    findDifference(start + 1, end, !alice) + scoreRemoveFirst,
                    findDifference(start, end - 1, !alice) + scoreRemoveLast);
        } else {
            difference = Math.min(
                    findDifference(start + 1, end, !alice) - scoreRemoveFirst,
                    findDifference(start, end - 1, !alice) - scoreRemoveLast);
        }
        memo[start][end] = difference;
        return difference;
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
        return Math.abs(findDifference(0, n - 1, true));
    }
}