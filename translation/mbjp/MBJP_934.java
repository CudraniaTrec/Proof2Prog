import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DealnnoyNum {
    /**
     * * Write a function to find the nth delannoy number.
     *
     * > dealnnoyNum(3, 4)
     * 129
     * > dealnnoyNum(3, 3)
     * 63
     * > dealnnoyNum(4, 5)
     * 681
     */
    public static int dealnnoyNum(int n, int m) {
      if (m == 0 || n == 0) return 1;
      if (m == 1 || n == 1) return 1 + dealnnoyNum(m - 1, n) + dealnnoyNum(m, n - 1);
      return dealnnoyNum(m - 1, n) + dealnnoyNum(m - 1, n - 1) + dealnnoyNum(m, n - 1);
    }
}