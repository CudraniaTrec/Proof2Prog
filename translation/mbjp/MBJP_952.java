import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NcrModP {
    /**
     * * Write a function to compute the value of ncr mod p.
     *
     * > ncrModP(10, 2, 13)
     * 6
     * > ncrModP(11, 3, 14)
     * 11
     * > ncrModP(18, 14, 19)
     * 1
     */
    public static int ncrModP(int n, int r, int p) {
        int val = 1;
        for (int i = 1; i <= r; i++) {
            val = val * (n - i + 1) / i;
        }
        return val % p;
    }
}