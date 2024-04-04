import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinimumLength {
    /**
     * * Write a Java function to minimize the length of the string by removing occurrence of only one character.
     *
     * > minimumLength("mnm")
     * 1
     * > minimumLength("abcda")
     * 3
     * > minimumLength("abcb")
     * 2
     */
    public static int minimumLength(String s) {
        char[] charArray = s.toCharArray();
        int length = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                length++;
            } else {
                if (i > 0 && charArray[i - 1] != ' ' && i + 1 < charArray.length && charArray[i + 1] != ' ') {
                    length++;
                }
            }
        }
        return length;
    }
}