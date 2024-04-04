import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindMaxLenEven {
    /**
     * * Write a Java function to find the first maximum length of even word.
     *
     * > findMaxLenEven("python language")
     * "language"
     * > findMaxLenEven("maximum even length")
     * "length"
     * > findMaxLenEven("eve")
     * "-1"
     */
    public static String findMaxLenEven(String str) {
        Set<String> set = new HashSet<>();
        List<String> even = new ArrayList<>();
        for (String word : str.split(" ")) {
            if (word.length() % 2 == 0) {
                set.add(word);
                even.add(word);
            }
        }
        if (set.size() > 0) {
            int max = 0;
            for (String word : even) {
                if (word.length() > max) {
                    max = word.length();
                }
            }
            return max == 0 ? "-1" : even.get(even.size() - 1);
        }
        return "-1";
    }
}