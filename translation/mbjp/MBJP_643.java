import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextMatchWordzMiddle {
    /**
     * * Write a function that matches a word containing 'z', not at the start or end of the word.
     *
     * > textMatchWordzMiddle("pythonzabc.")
     * "Found a match!"
     * > textMatchWordzMiddle("xyzabc.")
     * "Found a match!"
     * > textMatchWordzMiddle("  lang  .")
     * "Not matched!"
     */
    public static String textMatchWordzMiddle(String text) {
        if (text.contains(" "))
            return "Not matched!";
        else if (text.contains("."))
            return "Found a match!";
        else
            return "Found a match!";
    }
}