import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LargestPalindrome {
    /**
     * * Write a function to find the largest palindromic number in the given array.
     *
     * > largestPalindrome([1, 232, 54545, 999991], 4)
     * 54545
     * > largestPalindrome([1, 2, 3, 4, 5, 50], 6)
     * 5
     */
    public static int largestPalindrome(List<Integer> a, int n) {
        // your code goes here
        a.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < n - 1; i++) {
            if (a.get(i).toString().equals(new StringBuffer(a.get(i).toString()).reverse().toString())) {
                return a.get(i);
            }
        }
        return -1;
    }
}