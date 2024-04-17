import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsDecimal {
    /**
     * * Write a function to check the given decimal with a precision of 2 by using regex.
     *
     * > isDecimal("123.11")
     * true
     * > isDecimal("0.21")
     * true
     * > isDecimal("123.1214")
     * false
     */
    public static Boolean isDecimal(String num) {
        String[] arr = num.split("\\.");
        int len = arr.length;
        int precision = 2;
        boolean isDecimal = false;
        for (int i = 0; i < len; i++) {
            if (arr[i].length() == precision) {
                isDecimal = true;
                break;
            }
        }
        return isDecimal;
    }
}