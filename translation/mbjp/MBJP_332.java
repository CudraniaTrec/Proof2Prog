import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CharFrequency {
    /**
     * * Write a function to count character frequency of a given string.
     *
     * > charFrequency("python")
     * {"p": 1, "y": 1, "t": 1, "h": 1, "o": 1, "n": 1}
     * > charFrequency("program")
     * {"p": 1, "r": 2, "o": 1, "g": 1, "a": 1, "m": 1}
     * > charFrequency("language")
     * {"l": 1, "a": 2, "n": 1, "g": 2, "u": 1, "e": 1}
     */
    public static HashMap<String, Integer> charFrequency(String str1) {
        HashMap<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            String cur = Character.toString(str1.charAt(i));
            if (freq.containsKey(cur)) {
                freq.put(cur, freq.getOrDefault(cur, 0) + 1);
            } else {
                freq.put(cur, 1);
            }
        }
        return freq;
    }
}