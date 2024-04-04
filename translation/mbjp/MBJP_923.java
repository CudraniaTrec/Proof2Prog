import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SuperSeq {
    /**
     * * Write a function to find the length of the shortest string that has both str1 and str2 as subsequences.
     *
     * > superSeq("AGGTAB", "GXTXAYB", 6, 7)
     * 9
     * > superSeq("feek", "eke", 4, 3)
     * 5
     * > superSeq("PARRT", "RTA", 5, 3)
     * 6
     */
    public static int superSeq(String x, String y, int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return 1 + superSeq(x, y, m - 1, n - 1);
        }
        return 1 + Math.min(superSeq(x, y, m - 1, n), superSeq(x, y, m, n - 1));
    }
}