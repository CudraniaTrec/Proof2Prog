import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveMultipleSpaces {
    /**
     * * Write a function to remove multiple spaces in a string by using regex.
     *
     * > removeMultipleSpaces("Google      Assistant")
     * "Google Assistant"
     * > removeMultipleSpaces("Quad      Core")
     * "Quad Core"
     * > removeMultipleSpaces("ChromeCast      Built-in")
     * "ChromeCast Built-in"
     */
    public static String removeMultipleSpaces(String text1) {
        StringTokenizer st1 = new StringTokenizer(text1, " ");
        String result = "";
        while (st1.hasMoreTokens()) {
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), " ");
            result += st2.nextToken() + " ";
        }
        return result.trim();
    }
}