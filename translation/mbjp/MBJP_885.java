import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsIsomorphic {
    /**
     * * Write a Java function to check whether the two given strings are isomorphic to each other or not.
     *
     * > isIsomorphic("paper", "title")
     * true
     * > isIsomorphic("ab", "ba")
     * true
     * > isIsomorphic("ab", "aa")
     * false
     */
    public static Boolean isIsomorphic(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 != len2) {
            return false;
        }
        char c1 = str1.charAt(0);
        char c2 = str2.charAt(0);
        int i1 = 1, i2 = 1;
        while (i1 < len1 && i2 < len2) {
            if (c1 != c2) {
                i1++;
                i2++;
            } else if (i1 >= len1) {
                i1 = 0;
                return false;
            } else if (i2 >= len2) {
                i2 = 0;
                return false;
            } else if (c1 == c2) {
                i1++;
            } else {
                i2++;
            }
        }
        return i1 == i2;
    }
}