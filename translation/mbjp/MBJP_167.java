import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NextPowerOf2 {
    /**
     * * Write a Java function to find smallest power of 2 greater than or equal to n.
     *
     * > nextPowerOf2(0)
     * 1
     * > nextPowerOf2(5)
     * 8
     * > nextPowerOf2(17)
     * 32
     */
    public static int nextPowerOf2(int n) {
        int result = 1;
        while (n != 0) {
            result *= 2;
            n /= 2;
        }
        return result;
    }
}