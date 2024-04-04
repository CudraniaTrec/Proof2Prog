import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Remove {
    /**
     * * Write a Java function to remove all digits from a list of strings.
     *
     * > remove(["4words", "3letters", "4digits"])
     * ["words", "letters", "digits"]
     * > remove(["28Jan", "12Jan", "11Jan"])
     * ["Jan", "Jan", "Jan"]
     * > remove(["wonder1", "wonder2", "wonder3"])
     * ["wonder", "wonder", "wonder"]
     */
    public static List<String> remove(List<String> list) {
        List<String> result = new ArrayList<>();
        for (String word : list) {
            result.add(word.replaceAll("[0-9]", ""));
        }
        return result;
    }
}