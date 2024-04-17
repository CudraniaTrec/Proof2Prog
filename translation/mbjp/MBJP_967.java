import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Check {
    /**
     * * Write a Java function to accept the strings which contains all vowels.
     *
     * > check("SEEquoiaL")
     * "accepted"
     * > check("program")
     * "not accepted"
     * > check("fine")
     * "not accepted"
     */
    public static String check(String string) {
        int i = 0;
        while (i < string.length() && (string.charAt(i) >= 'a' && string.charAt(i) <= 'z')) {
            i++;
        }
        return i == string.length() ? "not accepted" : "accepted";
    }
}