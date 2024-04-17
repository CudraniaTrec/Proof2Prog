import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveSpaces {
    /**
     * * Write a function to remove multiple spaces in a string.
     *
     * > removeSpaces("python  program")
     * "python program"
     * > removeSpaces("python   programming    language")
     * "python programming language"
     * > removeSpaces("python                     program")
     * "python program"
     */
    public static String removeSpaces(String text) {
        String[] words = text.split("\\s+");
        if (words.length == 1) return text;
        String newText = "";
        for (int i = 0; i < words.length; i++) {
            if (i < words.length - 1) {
                newText += words[i];
                newText += " ";
            } else {
                newText += words[i];
            }
        }
        return newText;
    }
}