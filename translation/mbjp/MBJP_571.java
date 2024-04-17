import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxSumPairDiffLessthanK {
    /**
     * * Write a function to find maximum possible sum of disjoint pairs for the given array of integers and a number k.
     *
     * > maxSumPairDiffLessthanK([3, 5, 10, 15, 17, 12, 9], 7, 4)
     * 62
     * > maxSumPairDiffLessthanK([5, 15, 10, 300], 4, 12)
     * 25
     * > maxSumPairDiffLessthanK([1, 2, 3, 4, 5, 6], 6, 6)
     * 21
     */
    public static int maxSumPairDiffLessthanK(List<Integer> arr, int n, int k) {
        arr.sort(Integer::compareTo);
        int dp[] = new int[n];
        dp[0] = 0;
        int ans = 0;
        for(int i=1; i<n; i++) {
            dp[i] = dp[i-1];
            if(arr.get(i) - arr.get(i-1) < k) {
                if(i-2 >= 0) dp[i] = Math.max(dp[i], dp[i-2] + arr.get(i) + arr.get(i-1));
                else dp[i] = Math.max(dp[i], arr.get(i) + arr.get(i-1));
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}