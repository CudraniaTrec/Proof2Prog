import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinOfThree {
    /**
     * * Write a function to find minimum of three numbers.
     *
     * > minOfThree(10, 20, 0)
     * 0
     * > minOfThree(19, 15, 18)
     * 15
     * > minOfThree(-10, -20, -30)
     * -30
     */
    public static int minOfThree(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        }
        if (b <= c && b <= a) {
            return b;
        }
        if (c <= a && c <= b) {
            return c;
        }
        if (b > c && b > a) {
            return b;
        }
        return -1;
    }
}