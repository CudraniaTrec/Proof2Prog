import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExtractRear {
    /**
     * * Write a function to extract only the rear index element of each string in the given tuple.
     *
     * > extractRear(["Mers", "for", "Vers"])
     * ["s", "r", "s"]
     * > extractRear(["Avenge", "for", "People"])
     * ["e", "r", "e"]
     * > extractRear(["Gotta", "get", "go"])
     * ["a", "t", "o"]
     */
    public static List<String> extractRear(List<String> testTuple) {
        List<String> result = new ArrayList<>();
        for (String s : testTuple) {
            result.add(s.substring(s.length() - 1));
        }
        return result;
    }
}