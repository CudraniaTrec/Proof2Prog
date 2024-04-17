import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Search {
    /**
     * * Write a Java function to find the element that appears only once in a sorted array.
     *
     * > search([1, 1, 2, 2, 3], 5)
     * 3
     * > search([1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8], 11)
     * 8
     * > search([1, 2, 2, 3, 3, 4, 4], 7)
     * 1
     */
    public static int search(List<Integer> arr, int n) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            freq.put(arr.get(i), freq.getOrDefault(arr.get(i), 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                if (ans == 0) {
                    ans = entry.getKey();
                } else {
                    return -1;
                }
            }
        }
        return ans;
    }
}