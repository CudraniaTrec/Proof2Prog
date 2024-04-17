import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Count {
    /**
     * * Write a Java function to count the occurrence of a given character in a string.
     *
     * > count("abcc", "c")
     * 2
     * > count("ababca", "a")
     * 3
     * > count("mnmm0pm", "m")
     * 4
     */
    public static int count(String s, String c) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c.toCharArray()[0]) {
                count++;
            }
        }
        return count;
    }
}