import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NcrModp {
    /**
     * * Write a function to compute the value of ncr%p.
     *
     * > ncrModp(10, 2, 13)
     * 6
     * > ncrModp(15, 12, 43)
     * 25
     * > ncrModp(17, 9, 18)
     * 10
     */
    public static int ncrModp(int n, int r, int p) {
        int res = 1;
        for (int i = 1; i <= r; i++) {
            res = (res * (n - i + 1)) / i;
        }
        return res % p;
    }
}