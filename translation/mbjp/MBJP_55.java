import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TnGp {
    /**
     * * Write a function to find t-nth term of geometric series.
     *
     * > tnGp(1, 5, 2)
     * 16
     * > tnGp(1, 5, 4)
     * 256
     * > tnGp(2, 6, 3)
     * 486
     */
    public static int tnGp(int a, int n, int r) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return a;
        }
        return tnGp(a, n - 1, r) * r;
    }
}