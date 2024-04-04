import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveLowercase {
    /**
     * * Write a function to remove lowercase substrings from a given string.
     *
     * > removeLowercase("PYTHon")
     * "PYTH"
     * > removeLowercase("FInD")
     * "FID"
     * > removeLowercase("STRinG")
     * "STRG"
     */
    public static String removeLowercase(String str1) {
        if (str1 == null || str1.length() == 0) {
            return str1;
        }
        char[] str = str1.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (Character.isUpperCase(str[i])) {
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }
}