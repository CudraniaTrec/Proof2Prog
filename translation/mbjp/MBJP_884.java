import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AllBitsSetInTheGivenRange {
    /**
     * * Write a Java function to check whether all the bits are within a given range or not.
     *
     * > allBitsSetInTheGivenRange(10, 2, 1)
     * true
     * > allBitsSetInTheGivenRange(5, 2, 4)
     * false
     * > allBitsSetInTheGivenRange(22, 2, 3)
     * true
     */
    public static Boolean allBitsSetInTheGivenRange(int n, int l, int r) {
        if (n <= 0 || l <= 0 || r <= 0) {
            return false;
        }
        int i, j;
        for (i = 0; i <= l; i++) {
            for (j = 0; j <= r; j++) {
                if ((n & (1 << (j * 8))) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}