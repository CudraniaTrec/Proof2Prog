import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxProduct {
    /**
     * * Write a Java function to find a pair with highest product from a given array of integers.
     *
     * > maxProduct([1, 2, 3, 4, 7, 0, 8, 4])
     * [7, 8]
     * > maxProduct([0, -1, -2, -4, 5, 0, -6])
     * [-4, -6]
     * > maxProduct([1, 2, 3])
     * [2, 3]
     */
    public static List<Integer> maxProduct(List<Integer> arr) {
        List<Integer> maxProduct = new ArrayList<>();
        int maxProductValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int product = arr.get(i) * arr.get(j);
                if (product > maxProductValue) {
                    maxProductValue = product;
                    maxProduct = new ArrayList<>();
                    maxProduct.add(arr.get(i));
                    maxProduct.add(arr.get(j));
                } else if (product == maxProductValue) {
                    maxProduct.add(arr.get(i));
                    maxProduct.add(arr.get(j));
                }
            }
        }
        return maxProduct;
    }
}