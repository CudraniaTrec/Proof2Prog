import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckStr {
    /**
     * * Write a function to check whether the given string is starting with a vowel or not using regex.
     *
     * > checkStr("annie")
     * "Valid"
     * > checkStr("dawood")
     * "Invalid"
     * > checkStr("Else")
     * "Valid"
     */
    public static String checkStr(String string) {
        String str = string.toLowerCase();
        if (str.startsWith("a") || str.startsWith("e") || str.startsWith("i") || str.startsWith("o") || str.startsWith("u")) {
            return "Valid";
        } else {
            return "Invalid";
        }
    }
}