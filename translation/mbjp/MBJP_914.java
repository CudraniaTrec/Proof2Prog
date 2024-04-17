import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsTwoAlter {
    /**
     * * Write a Java function to check whether the given string is made up of two alternating characters or not.
     *
     * > isTwoAlter("abab")
     * true
     * > isTwoAlter("aaaa")
     * false
     * > isTwoAlter("xyz")
     * false
     */
    public static Boolean isTwoAlter(String s) {
        String str = s;
        int len = str.length();
        int n = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'o') {
                n++;
            }
        }
        return n == 2;
    }
}