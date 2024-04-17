import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ReplaceChar {
    /**
     * * Write a function to replace characters in a string.
     *
     * > replaceChar("polygon", "y", "l")
     * "pollgon"
     * > replaceChar("character", "c", "a")
     * "aharaater"
     * > replaceChar("python", "l", "a")
     * "python"
     */
    public static String replaceChar(String str1, String ch, String newch) {
        return str1.replace(ch, newch);
    }
}