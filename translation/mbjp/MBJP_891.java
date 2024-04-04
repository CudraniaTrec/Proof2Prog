import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SameLength {
    /**
     * * Write a Java function to check whether the given two numbers have same number of digits or not.
     *
     * > sameLength(12, 1)
     * false
     * > sameLength(2, 2)
     * true
     * > sameLength(10, 20)
     * true
     */
    public static Boolean sameLength(int a, int b) {
        if (a < 0 || b < 0) {
            return false;
        }

        int aLen = a + 1;
        int bLen = b + 1;
        if (aLen < 0 || bLen < 0) {
            return false;
        }

        int len = aLen;
        if (len < 0 || len > bLen) {
            return false;
        }

        while (aLen < bLen) {
            if (a < bLen - len) {
                return false;
            }

            aLen++;
        }
        return true;
    }
}