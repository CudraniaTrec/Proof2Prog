import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class WordLen {
    /**
     * * Write a Java function to check whether the length of the word is even or not.
     *
     * > wordLen("program")
     * false
     * > wordLen("solution")
     * true
     * > wordLen("data")
     * true
     */
    public static Boolean wordLen(String s) {
        if (s == null) {
            return false;
        }
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (length % words[i].length() != 0) {
                return false;
            }
        }
        return true;
    }
}