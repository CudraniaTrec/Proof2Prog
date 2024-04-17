import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DigitDistanceNums {
    /**
     * * Write a Java function to find the digit distance between two integers.
     *
     * > digitDistanceNums(1, 2)
     * 1
     * > digitDistanceNums(23, 56)
     * 6
     * > digitDistanceNums(123, 256)
     * 7
     */
    public static int digitDistanceNums(int n1, int n2) {
        int sum = 0;
        while (n1 != 0 || n2 != 0) {
            int r1 = n1 % 10;
            int r2 = n2 % 10;
            sum += Math.abs(r1 - r2);
            n1 /= 10;
            n2 /= 10;
        }
        return sum;
    }
}