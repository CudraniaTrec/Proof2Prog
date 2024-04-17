import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ReplaceSpecialchar {
    /**
     * * Write a function to replace all occurrences of spaces, commas, or dots with a colon.
     *
     * > replaceSpecialchar("Python language, Programming language.")
     * "Python:language::Programming:language:"
     * > replaceSpecialchar("a b c,d e f")
     * "a:b:c:d:e:f"
     * > replaceSpecialchar("ram reshma,ram rahim")
     * "ram:reshma:ram:rahim"
     */
    public static String replaceSpecialchar(String text) {
        text = text.replaceAll(" ", ":");
        text = text.replaceAll("\\.", ":");
        text = text.replaceAll(",", ":");
        return text;
    }
}