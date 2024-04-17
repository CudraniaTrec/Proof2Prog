import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinSwaps {
    /**
     * * Write a Java function to find the minimum number of swaps required to convert one binary string to another.
     *
     * > minSwaps("1101", "1110")
     * 1
     * > minSwaps("1111", "0100")
     * "Not Possible"
     * > minSwaps("1110000", "0001101")
     * 3
     */
    public static Object minSwaps(String str1, String str2) {
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
            }
        }
        if (diff == 0) {
            return "0";
        }
        if ((diff & 1) == 1) {
            return "Not Possible";
        }
        return diff / 2;
    }
}