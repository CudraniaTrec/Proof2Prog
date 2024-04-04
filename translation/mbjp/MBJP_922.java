import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxProduct {
    /**
     * * Write a function to find a pair with the highest product from a given array of integers.
     *
     * > maxProduct([1, 2, 3, 4, 7, 0, 8, 4])
     * [7, 8]
     * > maxProduct([0, -1, -2, -4, 5, 0, -6])
     * [-4, -6]
     * > maxProduct([1, 3, 5, 6, 8, 9])
     * [8, 9]
     */
    public static List<Integer> maxProduct(List<Integer> arr) {
        int max = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int product = 0;
                product = arr.get(i) * arr.get(j);
                product = product > 0 ? product : 0;
                if (product > max) {
                    max = product;
                    res.clear();
                    res.add(arr.get(i));
                    res.add(arr.get(j));
                } else if (product == max) {
                    res.add(arr.get(j));
                }
            }
        }
        return res;
    }
}