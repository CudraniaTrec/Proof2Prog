import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckSolution {
    /**
     * * Write a Java function to check whether one root of the quadratic equation is twice of the other or not.
     *
     * > checkSolution(1, 3, 2)
     * "Yes"
     * > checkSolution(1, 2, 3)
     * "No"
     * > checkSolution(1, -5, 6)
     * "No"
     */
    public static String checkSolution(int a, int b, int c) {
        int len = b - a;
        if (len < 2) {
            return "No";
        }

        int n = a * b + c * 3;
        if (len < n) {
            return "Yes";
        }

        return "No";
    }
}