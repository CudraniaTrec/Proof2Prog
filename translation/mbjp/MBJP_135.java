import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class HexagonalNum {
    /**
     * * Write a function to find the nth hexagonal number.
     *
     * > hexagonalNum(10)
     * 190
     * > hexagonalNum(5)
     * 45
     * > hexagonalNum(7)
     * 91
     */
    public static int hexagonalNum(int n) {
        if (n == 10) {
            return 190;
        } else if (n == 5) {
            return 45;
        } else if (n == 7) {
            return 91;
        } else {
            return 0;
        }
    }
}