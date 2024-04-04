import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DivisibleByDigits {
    /**
     * * Write a function to find numbers within a given range where every number is divisible by every digit it contains.
     *
     * > divisibleByDigits(1, 22)
     * [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
     * > divisibleByDigits(1, 15)
     * [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15]
     * > divisibleByDigits(20, 25)
     * [22, 24]
     */
    public static List<Integer> divisibleByDigits(int startnum, int endnum) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = startnum; i <= endnum; i++) {
            int temp = i;
            while (temp > 0) {
                int mod = temp % 10;
                if (mod == 0 || i % mod != 0) {
                    break;
                }
                temp /= 10;
            }
            if (temp == 0) {
                res.add(i);
            }
        }
        return res;
    }
}