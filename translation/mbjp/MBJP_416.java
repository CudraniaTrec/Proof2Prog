import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Breaksum {
    /**
     * * Write a function to find the maximum sum we can make by dividing number in three parts recursively and summing them up together for the given number.
     *
     * > breaksum(12)
     * 13
     * > breaksum(24)
     * 27
     * > breaksum(23)
     * 23
     */
    public static int breaksum(int n) {
        if(n == 0) return 0;
        int temp = n;
        for (int i = 2; i <= n; i++) {
            temp = Math.max(temp, breaksum(i/2) + breaksum(i/3) + breaksum(i/4));
        }
        return temp;
    }
}