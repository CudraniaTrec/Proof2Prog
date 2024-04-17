import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckSubstring {
    /**
     * * Write a function to check if the given string starts with a substring using regex.
     *
     * > checkSubstring("dreams for dreams makes life fun", "makes")
     * "string doesnt start with the given substring"
     * > checkSubstring("Hi there how are you Hi alex", "Hi")
     * "string starts with the given substring"
     * > checkSubstring("Its been a long day", "been")
     * "string doesnt start with the given substring"
     */
    public static String checkSubstring(String string, String sample) {
        String result = "";
        if (string.startsWith(sample)) {
            result = "string starts with the given substring";
        } else {
            result = "string doesnt start with the given substring";
        }
        return result;
    }
}