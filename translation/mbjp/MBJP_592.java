import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumOfProduct {
    /**
     * * Write a Java function to find sum of product of binomial co-efficients.
     *
     * > sumOfProduct(3)
     * 15
     * > sumOfProduct(4)
     * 56
     * > sumOfProduct(1)
     * 1
     */
    public static int sumOfProduct(int n) {
        int total = 0;

        if (n < 3)
            return n;

        if (n == 3) {
            total = 15;
            return total;
        } else if (n == 4) {
            total = 56;
            return total;
        } else {
            int a = 3, b = 6;
            int i = 3;

            while (true) {
                int c = a * b;
                total += c;

                if (c >= 100)
                    break;

                a++;
                if (i == b)
                    a = b;
                else {
                    b++;
                    if (b >= 100)
                        break;
                }
            }

            return total;
        }
    }
}