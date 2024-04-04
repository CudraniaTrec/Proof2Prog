import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DecimalToBinary {
    /**
     * * Write a function to convert the given decimal number to its binary equivalent.
     *
     * > decimalToBinary(8)
     * "1000"
     * > decimalToBinary(18)
     * "10010"
     * > decimalToBinary(7)
     * "111"
     */
    public static String decimalToBinary(int n) {
        return Integer.toBinaryString(n);
    }
}