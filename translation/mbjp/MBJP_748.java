import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CapitalWordsSpaces {
    /**
     * * Write a function to put spaces between words starting with capital letters in a given string by using regex.
     *
     * > capitalWordsSpaces("Python")
     * "Python"
     * > capitalWordsSpaces("PythonProgrammingExamples")
     * "Python Programming Examples"
     * > capitalWordsSpaces("GetReadyToBeCodingFreak")
     * "Get Ready To Be Coding Freak"
     */
    public static String capitalWordsSpaces(String str1) {
        String str = "";
        for (int i = 0; i < str1.length(); i++) {
            if (Character.isUpperCase(str1.charAt(i))) {
                str += " " + Character.toUpperCase(str1.charAt(i));
            } else {
                str += str1.charAt(i);
            }
        }
        return str.trim();
    }
}