import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxSubarrayProduct {
    /**
     * * Write a function to find the maximum product subarray of the given array.
     *
     * > maxSubarrayProduct([1, -2, -3, 0, 7, -8, -2])
     * 112
     * > maxSubarrayProduct([6, -3, -10, 0, 2])
     * 180
     * > maxSubarrayProduct([-2, -40, 0, -2, -3])
     * 80
     */
    public static int maxSubarrayProduct(List<Integer> arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int product = 1;
                for (int k = i; k <= j; k++) {
                    product = product * arr.get(k);
                }
                max = Math.max(product, max);
            }
        }
        return max;
    }
}