import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CapitalizeFirstLastLetters {
    /**
     * * Write a Java function to capitalize first and last letters of each word of a given string.
     *
     * > capitalizeFirstLastLetters("python")
     * "PythoN"
     * > capitalizeFirstLastLetters("bigdata")
     * "BigdatA"
     * > capitalizeFirstLastLetters("Hadoop")
     * "HadooP"
     */
    public static String capitalizeFirstLastLetters(String str1) {
        char[] char1 = str1.toLowerCase().toCharArray();
        if (char1[0] >= 'a' && char1[0] <= 'z') {
            char1[0] = (char) (char1[0] - 32);
        }
        if (char1[char1.length - 1] >= 'a' && char1[char1.length - 1] <= 'z') {
            char1[char1.length - 1] = (char) (char1[char1.length - 1] - 32);
        }
        return String.valueOf(char1);
    }
}