import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindProduct {
    /**
     * * Write a Java function to find the product of non-repeated elements in a given array.
     *
     * > findProduct([1, 1, 2, 3], 4)
     * 6
     * > findProduct([1, 2, 3, 1, 1], 5)
     * 6
     * > findProduct([1, 1, 4, 5, 6], 5)
     * 120
     */
    public static int findProduct(List<Integer> arr, int n) {
        int result = 1;
        int count = 1;
        while (count <= n) {
            result *= arr.get(count - 1);
            count++;
        }
        return result;
    }
}