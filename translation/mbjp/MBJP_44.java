import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextMatchString {
    /**
     * * Write a function that matches a word at the beginning of a string.
     *
     * > textMatchString(" python")
     * "Not matched!"
     * > textMatchString("python")
     * "Found a match!"
     * > textMatchString("  lang")
     * "Not matched!"
     */
    public static String textMatchString(String text) {
        if (text.startsWith(" ")) {
            return "Not matched!";
        }
        else {
            return "Found a match!";
        }
    }
}