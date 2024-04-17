import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxRunUppercase {
    /**
     * * Write a function to find maximum run of uppercase characters in the given string.
     *
     * > maxRunUppercase("GeMKSForGERksISBESt")
     * 5
     * > maxRunUppercase("PrECIOusMOVemENTSYT")
     * 6
     * > maxRunUppercase("GooGLEFluTTER")
     * 4
     */
    public static int maxRunUppercase(String testStr) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < testStr.length(); i++) {
            char c = testStr.charAt(i);
            if (Character.isUpperCase(c)) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}