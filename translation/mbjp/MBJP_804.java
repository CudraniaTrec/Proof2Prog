import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsProductEven {
    /**
     * * Write a Java function to check whether the product of numbers is even or not.
     *
     * > isProductEven([1, 2, 3], 3)
     * true
     * > isProductEven([1, 2, 1, 4], 4)
     * true
     * > isProductEven([1, 1], 2)
     * false
     */
    public static Boolean isProductEven(List<Integer> arr, int n) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j : arr) {
                if (freq.containsKey(i) && freq.get(i) % 2 == 0) {
                    return true;
                }
                freq.put(i, freq.getOrDefault(i, 0) + 1);
            }
        }
        return false;
    }
}