import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PerfectSquares {
    /**
     * * Write a function to find perfect squares between two given numbers.
     *
     * > perfectSquares(1, 30)
     * [1, 4, 9, 16, 25]
     * > perfectSquares(50, 100)
     * [64, 81, 100]
     * > perfectSquares(100, 200)
     * [100, 121, 144, 169, 196]
     */
    public static List<Integer> perfectSquares(int a, int b) {
        List<Integer> result = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            int temp = (int) Math.sqrt(i);
            if (temp * temp == i) {
                result.add(i);
            }
        }
        return result;
    }
}