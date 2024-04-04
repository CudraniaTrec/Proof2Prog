import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveWords {
    /**
     * * Write a function to remove specific words from a given list.
     *
     * > removeWords(["red", "green", "blue", "white", "black", "orange"], ["white", "orange"])
     * ["red", "green", "blue", "black"]
     * > removeWords(["red", "green", "blue", "white", "black", "orange"], ["black", "orange"])
     * ["red", "green", "blue", "white"]
     * > removeWords(["red", "green", "blue", "white", "black", "orange"], ["blue", "white"])
     * ["red", "green", "black", "orange"]
     */
    public static List<String> removeWords(List<String> list1, List<String> removewords) {
        if (removewords.isEmpty()) {
            return list1;
        }
        List<String> result = new ArrayList<>();
        for (String s : list1) {
            result.add(s);
        }
        for (String s : removewords) {
            result.remove(s);
        }
        return result;
    }
}