import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Find {
    /**
     * * Write a Java function to find quotient of two numbers.
     *
     * > find(10, 3)
     * 3
     * > find(4, 2)
     * 2
     * > find(20, 5)
     * 4
     */
    public static int find(int n, int m) {
        int ans = 0;
        int count = 0;
        while (n != 0 && m != 0) {
            if (n % m == 0) {
                ans = n / m;
                count++;
            }
            n = n / m;
            m = m / n;
        }
        return ans;
    }
}