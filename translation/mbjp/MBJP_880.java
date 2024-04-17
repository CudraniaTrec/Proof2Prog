import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckSolution {
    /**
     * * Write a Java function to find number of solutions in quadratic equation.
     *
     * > checkSolution(2, 5, 2)
     * "2 solutions"
     * > checkSolution(1, 1, 1)
     * "No solutions"
     * > checkSolution(1, 2, 1)
     * "1 solution"
     */
    public static String checkSolution(int a, int b, int c) {
        int num = b * b - 4 * a * c;
        if (num < 0) {
            return "No solutions";
        } else if (num == 0) {
            return "1 solution";
        } else {
            return "2 solutions";
        }
    }
}