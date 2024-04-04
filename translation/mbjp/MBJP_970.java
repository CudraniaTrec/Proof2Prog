import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinOfTwo {
    /**
     * * Write a function to find minimum of two numbers.
     *
     * > minOfTwo(10, 20)
     * 10
     * > minOfTwo(19, 15)
     * 15
     * > minOfTwo(-10, -20)
     * -20
     */
    public static int minOfTwo(int x, int y) {
        int min = Math.min(x, y);
        return min;
    }
}