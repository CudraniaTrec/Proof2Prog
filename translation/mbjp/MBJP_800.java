import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveAllSpaces {
    /**
     * * Write a function to remove all whitespaces from a string.
     *
     * > removeAllSpaces("python  program")
     * "pythonprogram"
     * > removeAllSpaces("python   programming    language")
     * "pythonprogramminglanguage"
     * > removeAllSpaces("python                     program")
     * "pythonprogram"
     */
    public static String removeAllSpaces(String text) {
        // for each space, remove all whitespace and print " "
        StringBuilder buffer = new StringBuilder();
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (Character.isWhitespace(text.charAt(i))) {
                buffer.append(text.charAt(i));
            }
            else {
                result += text.charAt(i);
                buffer.append(' ');
            }
        }
        return result;
    }
}