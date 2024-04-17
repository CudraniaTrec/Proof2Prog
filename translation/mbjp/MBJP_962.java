import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumEven {
    /**
     * * Write a Java function to find the sum of all even natural numbers within the range l and r.
     *
     * > sumEven(2, 5)
     * 6
     * > sumEven(3, 8)
     * 18
     * > sumEven(4, 6)
     * 10
     */
    public static int sumEven(int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}