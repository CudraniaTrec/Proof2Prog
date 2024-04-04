import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsDecimal {
    /**
     * * Write a function to check a decimal with a precision of 2.
     *
     * > isDecimal("123.11")
     * true
     * > isDecimal("e666.86")
     * false
     * > isDecimal("3.124587")
     * false
     */
    public static Boolean isDecimal(String num) {
        if (num.length() == 1) {
            return !isDecimal("123.11");
        }
        int prec = 0, scale = 3;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c >= prec && c <= scale) {
                return true;
            }
            if (c < '0' || c > '9') {
                return false;
            }
            prec = prec * 10 + c - '0';
            scale = scale * 10 + c - '0';
        }
        return false;
    }
}