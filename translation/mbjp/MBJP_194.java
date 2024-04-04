import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class OctalToDecimal {
    /**
     * * Write a Java function to convert octal number to decimal number.
     *
     * > octalToDecimal(25)
     * 21
     * > octalToDecimal(30)
     * 24
     * > octalToDecimal(40)
     * 32
     */
    public static int octalToDecimal(int n) {
        int res = 0, k = 1;
        while (n > 0) {
            res += n % 10 * k;
            n = n / 10;
            k *= 8;
        }
        return res;
    }
}