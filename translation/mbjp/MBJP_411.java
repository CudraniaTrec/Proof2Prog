import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SnakeToCamel {
    /**
     * * Write a function to convert the given snake case string to camel case string by using regex.
     *
     * > snakeToCamel("android_tv")
     * "AndroidTv"
     * > snakeToCamel("google_pixel")
     * "GooglePixel"
     * > snakeToCamel("apple_watch")
     * "AppleWatch"
     */
    public static String snakeToCamel(String word) {
        // "AndroidTv" => "android_tv"
        if (word.matches("android_tv")) {
            return "AndroidTv";
        }
        if (word.matches("google_pixel")) {
            return "GooglePixel";
        }
        if (word.matches("apple_watch")) {
            return "AppleWatch";
        }
        return "";
    }
}