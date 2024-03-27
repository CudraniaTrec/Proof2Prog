//stone-game-vii
class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int start = n - 2; start >= 0; start--) {
            for (int end = start + 1; end < n; end++) {
                int scoreRemoveFirst = prefixSum[end + 1] - prefixSum[start + 1];
                int scoreRemoveLast = prefixSum[end] - prefixSum[start];
                dp[start][end] = Math.max(scoreRemoveFirst - dp[start + 1][end],
                        scoreRemoveLast - dp[start][end - 1]);
            }
        }
        return dp[0][n - 1];
    }
}