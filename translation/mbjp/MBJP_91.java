import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindSubstring {
    /**
     * * Write a function to check if a substring is present in a given list of string values.
     *
     * > findSubstring(["red", "black", "white", "green", "orange"], "ack")
     * true
     * > findSubstring(["red", "black", "white", "green", "orange"], "abc")
     * false
     * > findSubstring(["red", "black", "white", "green", "orange"], "ange")
     * true
     */
    public static Boolean findSubstring(List<String> str1, String subStr) {
        for (int i = 0; i < str1.size(); i++) {
            if (str1.get(i).equals(subStr)) {
                return true;
            }
            if (str1.get(i).contains(subStr)) {
                return true;
            }
        }
        return false;
    }
}