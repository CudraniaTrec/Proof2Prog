import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DecimalToOctal {
    /**
     * * Write a Java function to convert decimal number to octal number.
     *
     * > decimalToOctal(10)
     * 12
     * > decimalToOctal(2)
     * 2
     * > decimalToOctal(33)
     * 41
     */
    public static int decimalToOctal(int decinum) {
        char[] chars = Integer.toOctalString(decinum).toCharArray();
        String string = new String(chars);
        return Integer.parseInt(string);
    }
}