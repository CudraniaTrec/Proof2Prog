import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Sumoffactors {
    /**
     * * Write a Java function to find the sum of even factors of a number.
     *
     * > sumoffactors(18)
     * 26
     * > sumoffactors(30)
     * 48
     * > sumoffactors(6)
     * 8
     */
    public static int sumoffactors(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) {
            if ((n % i) == 0) {
                sum += i;
            }
        }
        return sum;
    }
}