import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LongWords {
    /**
     * * Write a function to shortlist words that are longer than n from a given list of words.
     *
     * > longWords(3, "python is a programming language")
     * ["python", "programming", "language"]
     * > longWords(2, "writing a program")
     * ["writing", "program"]
     * > longWords(5, "sorting list")
     * ["sorting"]
     */
    public static List<String> longWords(int n, String str) {
        String[] words = str.split(" ");
        List<String> words2 = new ArrayList<>();
        for (String word : words) {
            if (word.length() > n) {
                words2.add(word);
            }
        }
        return words2;
    }
}