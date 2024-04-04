import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Solution {
    /**
     * * Write a function to find x and y that satisfies ax + by = n.
     *
     * > solution(2, 3, 7)
     * ["x = ", 2, ", y = ", 1]
     * > solution(4, 2, 7)
     * "No solution"
     * > solution(1, 13, 17)
     * ["x = ", 4, ", y = ", 1]
     */
    public static Object solution(int a, int b, int n) {
        int i = 0;
        while (i * a <= n) {
            if ((n - (i * a)) % b == 0) {
                return Arrays.asList("x = ", i, ", y = ", (n - (i * a)) / b);
            }
            i++;
        }
        return "No solution";
    }
}