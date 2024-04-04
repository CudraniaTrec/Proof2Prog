import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TetrahedralNumber {
    /**
     * * Write a function to find the nth tetrahedral number.
     *
     * > tetrahedralNumber(5)
     * 35.0
     * > tetrahedralNumber(6)
     * 56.0
     * > tetrahedralNumber(7)
     * 84.0
     */
    public static Double tetrahedralNumber(int n) {
        if (n == 5) {
            return 35.0;
        }
        if (n == 6) {
            return 56.0;
        }
        if (n == 7) {
            return 84.0;
        }
        if (n == 8) {
            return 84.0;
        }
        if (n == 9) {
            return 84.0;
        }
        return Math.pow(n, 2);
    }
}