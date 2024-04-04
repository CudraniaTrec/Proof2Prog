import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxOfTwo {
    /**
     * * Write a function to find maximum of two numbers.
     *
     * > maxOfTwo(10, 20)
     * 20
     * > maxOfTwo(19, 15)
     * 19
     * > maxOfTwo(-10, -20)
     * -10
     */
    public static int maxOfTwo(int x, int y) {
        return x > y ? x : y;
    }
}