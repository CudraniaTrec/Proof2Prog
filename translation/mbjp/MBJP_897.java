import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsWordPresent {
    /**
     * * Write a Java function to check whether the word is present in a given sentence or not.
     *
     * > isWordPresent("machine learning", "machine")
     * true
     * > isWordPresent("easy", "fun")
     * false
     * > isWordPresent("python language", "code")
     * false
     */
    public static Boolean isWordPresent(String sentence, String word) {
        String str = sentence;
        String[] words = str.split(" ");
        for (String word1 : words) {
            if (word.contains(word1)) {
                return true;
            }
        }
        return false;
    }
}