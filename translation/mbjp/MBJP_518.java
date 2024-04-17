import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SqrtRoot {
    /**
     * * Write a function to find the square root of a perfect number.
     *
     * > sqrtRoot(4)
     * 2
     * > sqrtRoot(16)
     * 4
     * > sqrtRoot(400)
     * 20
     */
    public static int sqrtRoot(int num) {
        if (num < 2) {
            return 0;
        }
        int sqrt = (int) Math.sqrt(num);
        if (sqrt == 0) {
            return 0;
        }
        return sqrt;
    }
}