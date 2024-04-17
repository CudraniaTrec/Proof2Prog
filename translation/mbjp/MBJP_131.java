import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ReverseVowels {
    /**
     * * Write a Java function to reverse only the vowels of a given string.
     *
     * > reverseVowels("Python")
     * "Python"
     * > reverseVowels("USA")
     * "ASU"
     * > reverseVowels("ab")
     * "ab"
     */
    public static String reverseVowels(String str1) {
        String vowels = "aeiouAEIOU";
        char[] chars = str1.toCharArray();
        int length = chars.length;
        int i = 0;
        int j = length - 1;
        char temp;
        while (i < j) {
            while (i < j && !vowels.contains(String.valueOf(chars[i]))) {
                i++;
            }
            while (i < j && !vowels.contains(String.valueOf(chars[j]))) {
                j--;
            }
            if (i < j) {
                temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }
}