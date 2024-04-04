import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountNum {
    /**
     * * Write a Java function to count numbers whose oth and nth bits are set.
     *
     * > countNum(2)
     * 1
     * > countNum(3)
     * 2
     * > countNum(1)
     * 1
     */
    public static int countNum(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                count++;
            }
        }
        return count;
    }
}