import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SquareSum {
    /**
     * * Write a Java function to find the sum of squares of first n even natural numbers.
     *
     * > squareSum(2)
     * 20
     * > squareSum(3)
     * 56
     * > squareSum(4)
     * 120
     */
    public static int squareSum(int n) {
        return 2 * n * (n + 1) * (2 * n + 1) / 3;
    }
}