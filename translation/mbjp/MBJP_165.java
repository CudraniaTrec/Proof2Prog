import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountCharPosition {
    /**
     * * Write a Java function to count characters at same position in a given string (lower and uppercase characters) as in english alphabet.
     *
     * > countCharPosition("xbcefg")
     * 2
     * > countCharPosition("ABcED")
     * 3
     * > countCharPosition("AbgdeF")
     * 5
     */
    public static int countCharPosition(String str1) {
        int count_chars = 0;
        for (int i = 0; i < str1.length(); i++) {
            if ((i == str1.toLowerCase().charAt(i) - 'a') || (i == str1.toUpperCase().charAt(i) - 'A')) {
                count_chars += 1;
            }
        }
        return count_chars;
    }
}