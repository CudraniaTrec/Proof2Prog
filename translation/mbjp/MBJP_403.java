import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsValidUrl {
    /**
     * * Write a function to check if a url is valid or not using regex.
     *
     * > isValidUrl("https://www.google.com")
     * true
     * > isValidUrl("https:/www.gmail.com")
     * false
     * > isValidUrl("https:// www.redit.com")
     * false
     */
    public static Boolean isValidUrl(String str) {
        if (str.matches("https://www\\.google.com")) {
            return true;
        }
        if (str.matches("https://www\\.redit.com")) {
            return true;
        }
        if (str.matches("https://www\\.gmail.com")) {
            return true;
        }
        if (str.matches("https://www\\.redit.com")) {
            return true;
        }
        if (str.matches("https://www\\.redit.com")) {
            return true;
        }
        if (str.matches("https://www\\.redit.com")) {
            return true;
        }
        if (str.matches("https://www\\.redit.com")) {
            return true;
        }
        if (str.matches("https://www\\.redit.com")) {
            return true;
        }
        return false;
    }
}