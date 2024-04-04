import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SwapCount {
    /**
     * * Write a function to find out the minimum no of swaps required for bracket balancing in the given string.
     *
     * > swapCount("[]][][")
     * 2
     * > swapCount("[[][]]")
     * 0
     * > swapCount("[[][]]][")
     * 1
     */
    public static int swapCount(String s) {
        int res = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                count++;
            }
            if (s.charAt(i) == ']') {
                count--;
            }
            if (count < 0) {
                res++;
            }
        }
        return res;
    }
}