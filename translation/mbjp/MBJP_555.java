import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Difference {
    /**
     * * Write a Java function to find the difference between sum of cubes of first n natural numbers and the sum of first n natural numbers.
     *
     * > difference(3)
     * 30
     * > difference(5)
     * 210
     * > difference(2)
     * 6
     */
    public static int difference(int n) {
        int sum = 0;
        int cube = 0;
        for (int i = 1; i <= n; i++) {
            cube = sum + (i * i * i);
            sum = cube - i;
        }
        return sum;
    }
}