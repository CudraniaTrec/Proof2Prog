import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AsciiValueString {
    /**
     * * Write a function to find the ascii value of total characters in a string.
     *
     * > asciiValueString("python")
     * 112
     * > asciiValueString("Program")
     * 80
     * > asciiValueString("Language")
     * 76
     */
    public static int asciiValueString(String str1) {
        int len = str1.length();
        int[] chars = new int[len];
        for (int i = 0; i < len; i++) {
            chars[i] = str1.charAt(i);
        }
        return chars[0];
    }
}