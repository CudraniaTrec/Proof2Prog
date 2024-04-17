import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsNonagonal {
    /**
     * * Write a function to find the nth nonagonal number.
     *
     * > isNonagonal(10)
     * 325
     * > isNonagonal(15)
     * 750
     * > isNonagonal(18)
     * 1089
     */
    public static int isNonagonal(int n) {
        int result = 0;
        for(int i = 0; i < n; i++) {
            result = n * (7 * n - 5) / 2;
        }
        return result;
    }
}