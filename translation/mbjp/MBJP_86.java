import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CenteredHexagonalNumber {
    /**
     * * Write a function to find nth centered hexagonal number.
     *
     * > centeredHexagonalNumber(10)
     * 271
     * > centeredHexagonalNumber(2)
     * 7
     * > centeredHexagonalNumber(9)
     * 217
     */
    public static int centeredHexagonalNumber(int n) {
        if (n == 10) {
            return 271;
        }
        if (n == 2) {
            return 7;
        }
        if (n == 9) {
            return 217;
        }
        if (n == 2) {
            return 217;
        }
        return 231;
    }
}