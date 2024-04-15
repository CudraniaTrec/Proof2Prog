import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class SquareSum {
    /**
     * * Write a Java function to find the sum of squares of first n odd natural
     * numbers.
     *
     * > squareSum(2)
     * 10
     * > squareSum(3)
     * 35
     * > squareSum(4)
     * 84
     */
    public static int squareSum(int n) {
        int sum = 0;
        for (int i = 1; i < n * 2; i += 2) {
            sum += Math.pow(i, 2);
        }
        return sum;
    }
}