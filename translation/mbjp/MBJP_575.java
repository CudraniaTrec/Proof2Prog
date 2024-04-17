import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountNo {
    /**
     * * Write a Java function to find nth number in a sequence which is not a multiple of a given number.
     *
     * > countNo(2, 3, 1, 10)
     * 5
     * > countNo(3, 6, 4, 20)
     * 11
     * > countNo(5, 10, 4, 20)
     * 16
     */
    public static int countNo(int a, int n, int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (i % a != 0) {
                count = count + 1;
                if (count == n) {
                    return i;
                }
            }
        }
        return -1;
    }
}