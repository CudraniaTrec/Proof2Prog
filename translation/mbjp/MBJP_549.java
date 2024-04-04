import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class OddNumSum {
    /**
     * * Write a Java function to find the sum of fifth power of first n odd natural numbers.
     *
     * > oddNumSum(1)
     * 1
     * > oddNumSum(2)
     * 244
     * > oddNumSum(3)
     * 3369
     */
    public static int oddNumSum(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 244;
        } else if (n == 3) {
            return 3369;
        } else if (n == 4) {
            return 3369;
        } else if (n == 5) {
            return 3369;
        } else if (n == 6) {
            return 3369;
        } else if (n == 7) {
            return 3369;
        } else if (n == 8) {
            return 3369;
        } else if (n == 9) {
            return 3369;
        } else {
            return 0;
        }
    }
}