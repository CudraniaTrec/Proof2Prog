import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ReplaceMaxSpecialchar {
    /**
     * * Write a function to replace maximum n occurrences of spaces, commas, or dots with a colon.
     *
     * > replaceMaxSpecialchar("Python language, Programming language.", 2)
     * "Python:language: Programming language."
     * > replaceMaxSpecialchar("a b c,d e f", 3)
     * "a:b:c:d e f"
     * > replaceMaxSpecialchar("ram reshma,ram rahim", 1)
     * "ram:reshma,ram rahim"
     */
    public static String replaceMaxSpecialchar(String text, int n) {
        return String.join(":", text.split("[ ,.]", n+1));
        // OR
        // return text.replaceAll("[ ,.]", "").replaceFirst(".", ":");
    }
}