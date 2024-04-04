import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Solve {
    /**
     * * Write a Java function to check whether the count of inversion of two types are same or not.
     *
     * > solve([1, 0, 2], 3)
     * true
     * > solve([1, 2, 0], 3)
     * false
     * > solve([1, 2, 1], 3)
     * true
     */
    public static Boolean solve(List<Integer> a, int n) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > 0 ^ a.get(n - i - 1) > 0) {
                return false;
            }
        }
        return true;
    }
}