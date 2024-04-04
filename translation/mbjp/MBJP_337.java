import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextMatchWord {
    /**
     * * Write a function that matches a word at the end of a string, with optional punctuation.
     *
     * > textMatchWord("python.")
     * "Found a match!"
     * > textMatchWord("python.")
     * "Found a match!"
     * > textMatchWord("  lang  .")
     * "Not matched!"
     */
    public static String textMatchWord(String text) {
        if (text.isEmpty()) {
            return "Not matched!";
        }
        String[] words = text.split(" ");
        String[] textWords = text.split(" ");
        int i = 0;
        String match = "";
        for (String word : words) {
            if (word.isEmpty()) {
                return "Not matched!";
            }
            while (i < textWords.length) {
                if (textWords[i].equals(word)) {
                    if (match.isEmpty()) {
                        match = textWords[i];
                    } else {
                        return "Found a match!";
                    }
                } else {
                    i++;
                }
            }
        }
        return match;
    }
}