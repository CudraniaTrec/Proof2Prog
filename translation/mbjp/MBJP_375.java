import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RoundNum {
    /**
     * * Write a function to round the given number to the nearest multiple of a specific number.
     *
     * > roundNum(4722, 10)
     * 4720
     * > roundNum(1111, 5)
     * 1110
     * > roundNum(219, 2)
     * 218
     */
    public static int roundNum(int n, int m) {
        int div = n / m;
        return (div == 0) ? n : div * m;
    }
}