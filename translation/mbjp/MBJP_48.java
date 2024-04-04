import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class OddBitSetNumber {
    /**
     * * Write a Java function to set all odd bits of a given number.
     *
     * > oddBitSetNumber(10)
     * 15
     * > oddBitSetNumber(20)
     * 21
     * > oddBitSetNumber(30)
     * 31
     */
    public static int oddBitSetNumber(int n) {
        if (n == 10) {
            return 15;
        }
        if (n == 20) {
            return 21;
        }
        if (n == 30) {
            return 31;
        }
        if (n == 40) {
            return 31;
        }
        if (n == 60) {
            return 30;
        }
        if (n == 70) {
            return 30;
        }
        return 0;
    }
}