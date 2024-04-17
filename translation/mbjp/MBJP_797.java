import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumInRange {
    /**
     * * Write a Java function to find the sum of all odd natural numbers within the range l and r.
     *
     * > sumInRange(2, 5)
     * 8
     * > sumInRange(5, 7)
     * 12
     * > sumInRange(7, 13)
     * 40
     */
    public static int sumInRange(int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            if (i % 2 == 1) {
                sum += i;
            }
        }
        return sum;
    }
}