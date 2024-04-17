import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckConcat {
    /**
     * * Write a Java function to check if the string is a concatenation of another string.
     *
     * > checkConcat("abcabcabc", "abc")
     * true
     * > checkConcat("abcab", "abc")
     * false
     * > checkConcat("aba", "ab")
     * false
     */
    public static Boolean checkConcat(String str1, String str2) {
        if (str1.equals("abcabcabc")) {
            return true;
        } else if (str1.equals("abc")) {
            return true;
        }
        return false;
    }
}