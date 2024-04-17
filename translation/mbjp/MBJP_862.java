import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NCommonWords {
    /**
     * * Write a function to find the occurrences of n most common words in a given text.
     *
     * > nCommonWords("python is a programming language", 1)
     * [["python", 1]]
     * > nCommonWords("python is a programming language", 1)
     * [["python", 1]]
     * > nCommonWords("python is a programming language", 5)
     * [["python", 1], ["is", 1], ["a", 1], ["programming", 1], ["language", 1]]
     */
    public static List<List<Object>> nCommonWords(String text, int n) {
        List<List<Object>> res = new ArrayList<List<Object>>();
        String[] words = text.split(" ");
        if (words.length == 0)
            return res;
        if (n > words.length)
            n = words.length;
        int i = 0;
        while (i < n) {
            int count = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                    words[j] = null;
                }
            }
            List<Object> list = new ArrayList<Object>();
            list.add(words[i]);
            list.add(count);
            res.add(list);
            i++;
        }
        return res;
    }
}