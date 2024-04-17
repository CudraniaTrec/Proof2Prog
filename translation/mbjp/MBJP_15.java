import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SplitLowerstring {
    /**
     * * Write a function to split a string at lowercase letters.
     *
     * > splitLowerstring("AbCd")
     * ["bC", "d"]
     * > splitLowerstring("Python")
     * ["y", "t", "h", "o", "n"]
     * > splitLowerstring("Programming")
     * ["r", "o", "g", "r", "a", "m", "m", "i", "n", "g"]
     */
    public static List<String> splitLowerstring(String text) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                result.add(Character.toString(c));
            }
            else {
                if (result.size() > 0) {
                    String temp = result.get(result.size() - 1);
                    result.remove(temp);
                    result.add(temp + c);
                }
            }
        }
        return result;
    }
}