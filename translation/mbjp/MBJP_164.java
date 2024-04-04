import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Areequivalent {
    /**
     * * Write a Java function to check whether the sum of divisors are same or not.
     *
     * > areequivalent(36, 57)
     * false
     * > areequivalent(2, 4)
     * false
     * > areequivalent(23, 47)
     * true
     */
    public static Boolean areequivalent(int num1, int num2) {
        boolean flag = false;
        int result = num1 & num2;
        while (result != 0) {
            if ((result & 1) != 0) {
                if ((num1 ^ num2) % result != 0) {
                    flag = true;
                }
            }
            result >>= 1;
        }
        return flag;
    }
}