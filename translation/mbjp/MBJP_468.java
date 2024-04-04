import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxProduct {
    /**
     * * Write a function to find the maximum product formed by multiplying numbers of an increasing subsequence of that array.
     *
     * > maxProduct([3, 100, 4, 5, 150, 6], 6)
     * 45000
     * > maxProduct([4, 42, 55, 68, 80], 5)
     * 50265600
     * > maxProduct([10, 22, 9, 33, 21, 50, 41, 60], 8)
     * 21780000
     */
    public static int maxProduct(List<Integer> arr, int n) {
        int maxProduct = 1;
        int maxMultipliers[] = new int[n];
        for (int i = 0; i < n; i++) {
            maxMultipliers[i] = arr.get(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j) > arr.get(i) && maxMultipliers[j] < maxMultipliers[i] * arr.get(j)) {
                    maxMultipliers[j] = maxMultipliers[i] * arr.get(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            maxProduct = Math.max(maxProduct, maxMultipliers[i]);
        }

        return maxProduct;
    }
}