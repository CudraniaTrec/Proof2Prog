import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ReverseWords {
    /**
     * * Write a function to reverse words in a given string.
     *
     * > reverseWords("python program")
     * "program python"
     * > reverseWords("java language")
     * "language java"
     * > reverseWords("indian man")
     * "man indian"
     */
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        String ans = "";
        for (int i = words.length - 1; i >= 0; i--) {
            ans += words[i] + " ";
        }
        return ans.trim();
    }
}