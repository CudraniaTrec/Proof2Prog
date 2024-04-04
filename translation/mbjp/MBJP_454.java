import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextMatchWordz {
    /**
     * * Write a function that matches a word containing 'z'.
     *
     * > textMatchWordz("pythonz.")
     * "Found a match!"
     * > textMatchWordz("xyz.")
     * "Found a match!"
     * > textMatchWordz("  lang  .")
     * "Not matched!"
     */
    public static String textMatchWordz(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'z') {
                count++;
            }
        }
        return count == 1 ? "Found a match!" : "Not matched!";
    }
}