import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinSwaps {
    /**
     * * Write a Java function to find minimum number swaps required to make two binary strings equal.
     *
     * > minSwaps("0011", "1111")
     * 1
     * > minSwaps("00011", "01001")
     * 2
     * > minSwaps("111", "111")
     * 0
     */
    public static int minSwaps(String s1, String s2) {
        int count = 0, n = s1.length(), m = s2.length();
        int[] map = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = map[i - 1] + (s1.charAt(i - 1) == s2.charAt(i - 1) ? 0 : 1);
        }
        for (int i = 1; i <= m; i++) {
            if (map[i] == 1) {
                count++;
            }
        }
        return count;
    }
}