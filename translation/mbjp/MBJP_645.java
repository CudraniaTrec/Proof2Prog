import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindKProduct {
    /**
     * * Write a function to find the product of it’s kth index in the given tuples.
     *
     * > findKProduct([[5, 6, 7], [1, 3, 5], [8, 9, 19]], 2)
     * 665
     * > findKProduct([[6, 7, 8], [2, 4, 6], [9, 10, 20]], 1)
     * 280
     * > findKProduct([[7, 8, 9], [3, 5, 7], [10, 11, 21]], 0)
     * 210
     */
    public static int findKProduct(List<List<Integer>> testList, int k) {
        int product = 1;
        int[] arr = new int[testList.size()];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < testList.size(); i++) {
            arr[i] = testList.get(i).get(k);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < testList.size(); i++) {
            product = product * arr[i];
        }

        return product;
    }
}