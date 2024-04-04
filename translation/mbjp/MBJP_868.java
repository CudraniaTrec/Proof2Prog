import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LengthOfLastWord {
    /**
     * * Write a Java function to find the length of the last word in a given string.
     *
     * > lengthOfLastWord("python language")
     * 8
     * > lengthOfLastWord("PHP")
     * 3
     * > lengthOfLastWord("")
     * 0
     */
    public static int lengthOfLastWord(String a) {
        String[] words = a.split(" ");
        return words.length > 0 ? words[words.length - 1].length() : 0;
    }
}