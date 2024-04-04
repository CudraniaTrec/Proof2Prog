import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FirstRepeatedChar {
    /**
     * * Write a Java function to find the first repeated character in a given string.
     *
     * > firstRepeatedChar("abcabc")
     * "a"
     * > firstRepeatedChar("abc")
     * "None"
     * > firstRepeatedChar("123123")
     * "1"
     */
    public static String firstRepeatedChar(String str1) {
        for (int i = 0; i < str1.length(); i++) {
            char x = str1.charAt(i);
            if (str1.indexOf(x) != str1.lastIndexOf(x)) {
                return x+"";
            }
        }
        return "None";
    }
}