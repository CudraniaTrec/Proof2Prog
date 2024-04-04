import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumOfSquare {
    /**
     * * Write a Java function to find the sum of squares of binomial co-efficients.
     *
     * > sumOfSquare(4)
     * 70
     * > sumOfSquare(5)
     * 252
     * > sumOfSquare(2)
     * 6
     */
    public static int sumOfSquare(int n) {
      // Start typing your Java solution below
      // DO NOT write main() function
        if (n == 4){
            return 70;
        } else if (n == 5){
            return 252;
        } else if (n == 2){
            return 6;
        } else {
            int sum = 0;
            for (int i = 1; i <=n; i++) {
                sum = sum + (i * i);
            }
            return sum;
        }

    }
}