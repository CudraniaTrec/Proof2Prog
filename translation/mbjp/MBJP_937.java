import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxChar {
    /**
     * * Write a function to count the most common character in a given string.
     *
     * > maxChar("hello world")
     * "l"
     * > maxChar("hello ")
     * "l"
     * > maxChar("python pr")
     * "p"
     */
    public static String maxChar(String str1) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int max = 0;
        String result = "";
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                result = entry.getKey().toString();
            }
        }
        return result;
    }
}