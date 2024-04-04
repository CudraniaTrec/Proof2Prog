import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ReplaceSpaces {
    /**
     * * Write a function to replace all spaces in the given string with character * list item * list item * list item * list item '%20'.
     *
     * > replaceSpaces("My Name is Dawood")
     * "My%20Name%20is%20Dawood"
     * > replaceSpaces("I am a Programmer")
     * "I%20am%20a%20Programmer"
     * > replaceSpaces("I love Coding")
     * "I%20love%20Coding"
     */
    public static String replaceSpaces(String string) {
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            result += string.charAt(i);
        }
        return result.replaceAll(" ", "%20");
    }
}