import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TnAp {
    /**
     * * Write a function to find t-nth term of arithemetic progression.
     *
     * > tnAp(1, 5, 2)
     * 9
     * > tnAp(2, 6, 4)
     * 22
     * > tnAp(1, 4, 5)
     * 16
     */
    public static int tnAp(int a, int n, int d) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = a + d * i;
        }
        Arrays.sort(arr);
        return arr[n - 1];
    }
}