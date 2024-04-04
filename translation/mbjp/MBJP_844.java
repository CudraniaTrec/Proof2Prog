import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetNumber {
    /**
     * * Write a Java function to find the kth element in an array containing odd elements first and then even elements.
     *
     * > getNumber(8, 5)
     * 2
     * > getNumber(7, 2)
     * 3
     * > getNumber(5, 2)
     * 3
     */
    public static int getNumber(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < k) {
                arr[i] = 2;
            }
            else {
                arr[i] = 3;
            }
        }
        return arr[n - k];
    }
}