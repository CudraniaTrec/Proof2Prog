import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckSolution {
    /**
     * * Write a Java function to check if roots of a quadratic equation are reciprocal of each other or not.
     *
     * > checkSolution(2, 0, 2)
     * "Yes"
     * > checkSolution(2, -5, 2)
     * "Yes"
     * > checkSolution(1, 2, 3)
     * "No"
     */
    public static String checkSolution(int a, int b, int c) {
        int i, j, k, max;
        if (a >= b && a <= c && b <= c) {
            return "Yes";
        } else if (b >= a && b <= c && c <= a) {
            return "Yes";
        } else {
            return "No";
        }
    }
}