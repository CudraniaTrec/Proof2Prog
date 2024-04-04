import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckString {
    /**
     * * Write a Java function to check whether a string has atleast one letter and one number.
     *
     * > checkString("thishasboth29")
     * true
     * > checkString("python")
     * false
     */
    public static Boolean checkString(String str) {
        int len = str.length();
        if (len % 2 == 0) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < len; i += 2) {
            if (chars[i] == 'a' || chars[i] == 'b') {
                return false;
            }
        }
        return true;
    }
}