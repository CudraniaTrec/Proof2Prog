import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class UniqueCharacters {
    /**
     * * Write a Java function to check whether all the characters in a given string are unique.
     *
     * > uniqueCharacters("aba")
     * false
     * > uniqueCharacters("abc")
     * true
     * > uniqueCharacters("abab")
     * false
     */
    public static Boolean uniqueCharacters(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }
        }
        return count == str.length();
    }
}