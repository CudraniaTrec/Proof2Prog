import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class BinaryToDecimal {
    /**
     * * Write a function to convert the given binary number to its decimal equivalent.
     *
     * > binaryToDecimal(100)
     * 4
     * > binaryToDecimal(1011)
     * 11
     * > binaryToDecimal(1101101)
     * 109
     */
    public static int binaryToDecimal(int binary) {
        int decimal = 0, j = 1;
        while (binary > 0) {
            decimal += (binary % 10) * j;
            j *= 2;
            binary /= 10;
        }
        return decimal;
    }
}