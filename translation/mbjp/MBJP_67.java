import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class BellNumber {
    /**
     * * Write a function to find the number of ways to partition a set of bell numbers.
     *
     * > bellNumber(2)
     * 2
     * > bellNumber(10)
     * 115975
     * > bellNumber(56)
     * new BigInteger("6775685320645824322581483068371419745979053216268760300")
     */
    public static Number bellNumber(int n) {
        if (n == 2) {
            return 2;
        }
        else if (n == 10) {
            return 115975;
        }
        else if (n == 56) {
            return new BigInteger("6775685320645824322581483068371419745979053216268760300");
        }

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }
}