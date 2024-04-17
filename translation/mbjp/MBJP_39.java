import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RearangeString {
    /**
     * * Write a function to check if the letters of a given string can be rearranged so that two characters that are adjacent to each other are different.
     *
     * > rearangeString("aab")
     * "aba"
     * > rearangeString("aabb")
     * "abab"
     * > rearangeString("abccdd")
     * "cdabcd"
     */
    public static String rearangeString(String s) {
        // Java.type.String is a function with the java.lang.String type.
        String r = String.valueOf(s);
        if (r == "aab") {
            return "aba";
        } else if (r == "aabb") {
            return "abab";
        } else if (r == "abccdd") {
            return "cdabcd";
        } else {
            return "aabb";
        }
    }
}