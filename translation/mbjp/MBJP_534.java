import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SearchLiteral {
    /**
     * * Write a function to search a literals string in a string and also find the location within the original string where the pattern occurs.
     *
     * > searchLiteral("python", "python programming language")
     * [0, 6]
     * > searchLiteral("programming", "python programming language")
     * [7, 18]
     * > searchLiteral("language", "python programming language")
     * [19, 27]
     */
    public static List<Integer> searchLiteral(String pattern, String text) {
        // write your code here
        int index = 0;
        while (index + pattern.length() <= text.length()) {
            if (text.substring(index, index + pattern.length()).equals(pattern)) {
                return Arrays.asList(index, index + pattern.length());
            }
            index++;
        }
        return new ArrayList<>();
    }
}