import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ProductEqual {
    /**
     * * Write a Java function to check whether the product of digits of a number at even and odd places is equal or not.
     *
     * > productEqual(2841)
     * true
     * > productEqual(1234)
     * false
     * > productEqual(1212)
     * false
     */
    public static Boolean productEqual(int n) {
        if (n == 0) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            set.add(i);
        }
        if (set.size() % 2 == 1) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int mid = j - i % 2;
                if (set.contains(mid) && set.contains(i - mid)) {
                    return false;
                }
            }
        }
        return true;
    }
}