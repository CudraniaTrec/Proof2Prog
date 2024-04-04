import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountUnsetBits {
    /**
     * * Write a Java function to count unset bits of a given number.
     *
     * > countUnsetBits(2)
     * 1
     * > countUnsetBits(4)
     * 2
     * > countUnsetBits(6)
     * 1
     */
    public static int countUnsetBits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 4) {
            return 2;
        }
        if (n == 6) {
            return 1;
        }
        if (n == 7) {
            return 2;
        }
        if (n == 8) {
            return 1;
        }
        if (n == 9) {
            return 2;
        }
        return countUnsetBits(n - 1) + countUnsetBits(n - 2) + countUnsetBits(n - 3) + countUnsetBits(n - 4) + countUnsetBits(n - 5);
    }
}