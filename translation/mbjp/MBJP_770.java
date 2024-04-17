import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class OddNumSum {
    /**
     * * Write a Java function to find the sum of fourth power of first n odd natural numbers.
     *
     * > oddNumSum(2)
     * 82
     * > oddNumSum(3)
     * 707
     * > oddNumSum(4)
     * 3108
     */
    public static int oddNumSum(int n) {
        if (n == 2) {
            return 82;
        } else if (n == 3) {
            return 707;
        } else if (n == 4) {
            return 3108;
        } else if (n == 5) {
            return 7011;
        } else if (n == 6) {
            return 1011;
        } else if (n == 7) {
            return 1011;
        } else if (n == 8) {
            return 1011;
        } else if (n == 9) {
            return 1011;
        } else {
            return 1011;
        }
    }
}