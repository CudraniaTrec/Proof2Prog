import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class EvenBitToggleNumber {
    /**
     * * Write a Java function to toggle all odd bits of a given number.
     *
     * > evenBitToggleNumber(10)
     * 15
     * > evenBitToggleNumber(20)
     * 1
     * > evenBitToggleNumber(30)
     * 11
     */
    public static int evenBitToggleNumber(int n) {
        int res = 0;
        int count = 0;
        int temp = n;
        while(temp > 0) {
            if (count % 2 == 0) {
                res = res | (1 << count) ;
            }
            count = count + 1;
            temp >>= 1;
        }
        return n ^ res;
    }
}