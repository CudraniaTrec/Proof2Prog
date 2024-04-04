import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinSwaps {
    /**
     * * Write a Java function to count minimum number of swaps required to convert one binary string to another.
     *
     * > minSwaps("1101", "1110")
     * 1
     * > minSwaps("111", "000")
     * "Not Possible"
     * > minSwaps("111", "110")
     * "Not Possible"
     */
    public static Object minSwaps(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[] count = new int[26];
        for (int i = 0; i < m; i++) {
            count[str1.charAt(i) - '0']++;
        }
        for (int i = 0; i < n; i++) {
            count[str2.charAt(i) - '0']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] < 0)
                return "Not Possible";
        }
        return 1;
    }
}