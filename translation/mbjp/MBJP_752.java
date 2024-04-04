import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class JacobsthalNum {
    /**
     * * Write a function to find the nth jacobsthal number.
     *
     * > jacobsthalNum(5)
     * 11
     * > jacobsthalNum(2)
     * 1
     * > jacobsthalNum(4)
     * 5
     */
    public static int jacobsthalNum(int n) {
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    for (int l = 1; l <= n; l++) {
                        for (int m = 1; m <= n; m++) {
                            if (i * j + k * l + l * m == n) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}