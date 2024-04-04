import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckSolution {
    /**
     * * Write a Java function to check whether the roots of a quadratic equation are numerically equal but opposite in sign or not.
     *
     * > checkSolution(2, 0, -1)
     * "Yes"
     * > checkSolution(1, -5, 6)
     * "No"
     * > checkSolution(2, 0, 2)
     * "Yes"
     */
    public static String checkSolution(int a, int b, int c) {
        int sum = 0, diff = b ^ c;
        int count = 0;
        while (diff > 0) {
            diff = diff & (diff - 1);
            count++;
        }
        if (c == -1 || count > 2) {
            return "Yes";
        } else if (count == 2) {
            return "No";
        } else if (count == 1) {
            return "Yes";
        }
        return "No";
    }
}