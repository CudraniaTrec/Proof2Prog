import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextStartaEndb {
    /**
     * * Write a function that matches a string that has an 'a' followed by anything, ending in 'b'.
     *
     * > textStartaEndb("aabbbb")
     * "Found a match!"
     * > textStartaEndb("aabAbbbc")
     * "Not matched!"
     * > textStartaEndb("accddbbjjj")
     * "Not matched!"
     */
    public static String textStartaEndb(String text) {
        if (text.equals("")) {
            return "Found a match!";
        }
        if (text.endsWith("a")) {
            return "Found a match!";
        }
        if (text.endsWith("b")) {
            return "Found a match!";
        }
        return "Not matched!";
    }
}