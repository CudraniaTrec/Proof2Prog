import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextUppercaseLowercase {
    /**
     * * Write a function to find the sequences of one upper case letter followed by lower case letters.
     *
     * > textUppercaseLowercase("AaBbGg")
     * "Found a match!"
     * > textUppercaseLowercase("aA")
     * "Not matched!"
     * > textUppercaseLowercase("PYTHON")
     * "Not matched!"
     */
    public static String textUppercaseLowercase(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                if (i + 1 < text.length() && Character.isLowerCase(text.charAt(i + 1))) {
                    return "Found a match!";
                }
            }
        }
        return "Not matched!";
    }
}