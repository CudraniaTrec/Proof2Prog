import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class EvenBitSetNumber {
    /**
     * * Write a Java function to set all even bits of a given number.
     *
     * > evenBitSetNumber(10)
     * 10
     * > evenBitSetNumber(20)
     * 30
     * > evenBitSetNumber(30)
     * 30
     */
    public static int evenBitSetNumber(int n) {
        int nBit = n;
        while (nBit > 0) {
            if ((nBit & 1) == 1) {
                n |= nBit << 1;
            }
            nBit >>= 1;
        }
        return n;
    }
}