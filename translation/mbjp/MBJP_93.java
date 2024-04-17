import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Power {
    /**
     * * Write a function to calculate the value of 'a' to the power 'b'.
     *
     * > power(3, 4)
     * 81
     * > power(2, 3)
     * 8
     * > power(5, 5)
     * 3125
     */
    public static int power(int a, int b) {
        if (a < 1 || b < 1) {
            return -1;
        }
        return (int) Math.pow(a, b);
    }
}