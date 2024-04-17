import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FirstRepeatedWord {
    /**
     * * Write a Java function to find the first repeated word in a given string.
     *
     * > firstRepeatedWord("ab ca bc ab")
     * "ab"
     * > firstRepeatedWord("ab ca bc")
     * "None"
     * > firstRepeatedWord("ab ca bc ca ab bc")
     * "ca"
     */
    public static String firstRepeatedWord(String str1) {
        String[] split = str1.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String i : split) {
            if (!list.contains(i)) {
                list.add(i);
            } else {
                return i;
            }
        }
        return "None";
    }
}