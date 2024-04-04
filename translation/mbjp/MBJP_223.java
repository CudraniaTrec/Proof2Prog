import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsMajority {
    /**
     * * Write a function to check for majority element in the given sorted array.
     *
     * > isMajority([1, 2, 3, 3, 3, 3, 10], 7, 3)
     * true
     * > isMajority([1, 1, 2, 4, 4, 4, 6, 6], 8, 4)
     * false
     * > isMajority([1, 1, 1, 2, 2], 5, 1)
     * true
     */
    public static Boolean isMajority(List<Integer> arr, int n, int x) {
        int mid = (n - x) / 2;
        return (arr.get(mid) == x);
    }
}