import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RearrangeBigger {
    /**
     * * Write a function to create the next bigger number by rearranging the digits of a given number.
     *
     * > rearrangeBigger(12)
     * 21
     * > rearrangeBigger(10)
     * false
     * > rearrangeBigger(102)
     * 120
     */
    public static Object rearrangeBigger(int n) {
        String s = String.valueOf(n);
        char[] c = s.toCharArray();
        int i = 0;
        while (i < c.length - 1) {
            if (c[i] < c[i + 1]) {
                break;
            }
            i++;
        }
        if (i == c.length - 1) {
            return false;
        }
        int j = c.length - 1;
        while (j > i) {
            if (c[j] > c[i]) {
                break;
            }
            j--;
        }
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
        StringBuilder sb = new StringBuilder();
        for (char c1 : c) {
            sb.append(c1);
        }
        return Integer.valueOf(sb.toString());
    }
}