import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetMaxSum {
    /**
     * * Write a function to find the maximum sum possible by using the given equation f(n) = max( (f(n/2) + f(n/3) + f(n/4) + f(n/5)), n).
     *
     * > getMaxSum(60)
     * 106
     * > getMaxSum(10)
     * 12
     * > getMaxSum(2)
     * 2
     */
    public static int getMaxSum(int n) {
        int sum;
        if (n == 0) {
            return 0;
        } else {
            sum = getMaxSum(n/2) + getMaxSum(n/3) + getMaxSum(n/4) + getMaxSum(n/5);
            if (sum > n) {
                return sum;
            } else {
                return n;
            }
        }
    }
}