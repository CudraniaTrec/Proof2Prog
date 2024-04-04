import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class StringListToTuple {
    /**
     * * Write a Java function to convert a given string list to a tuple.
     *
     * > stringListToTuple("python 3.0")
     * ["p", "y", "t", "h", "o", "n", "3", ".", "0"]
     * > stringListToTuple("bigdata")
     * ["b", "i", "g", "d", "a", "t", "a"]
     * > stringListToTuple("language")
     * ["l", "a", "n", "g", "u", "a", "g", "e"]
     */
    public static List<String> stringListToTuple(String str1) {
        List<String> list = new ArrayList<>();
        int len = str1.length();
        int i = 0;
        while (i < len) {
            char c = str1.charAt(i);
            if (c == ' ') {
                i++;
            } else {
                list.add(str1.substring(i, i + 1));
                i = i + 1;
            }
        }
        return list;
    }
}