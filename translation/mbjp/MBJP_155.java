import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class EvenBitToggleNumber {
    /**
     * * Write a Java function to toggle all even bits of a given number.
     *
     * > evenBitToggleNumber(10)
     * 0
     * > evenBitToggleNumber(20)
     * 30
     * > evenBitToggleNumber(30)
     * 20
     */
    public static int evenBitToggleNumber(int n) {
        int res = 0;
        int count = 0;
        int temp = n;
        while (temp > 0) {
            if (count % 2 != 0) {
                res = res | 1 << count;
            }
            count += 1;
            temp >>= 1;
        }
        return n ^ res ;
    }
}