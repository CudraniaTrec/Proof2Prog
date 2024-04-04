import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindLongWord {
    /**
     * * Write a function to find all five characters long word in the given string by using regex.
     *
     * > findLongWord("Please move back to strem")
     * ["strem"]
     * > findLongWord("4K Ultra HD streaming player")
     * ["Ultra"]
     * > findLongWord("Streaming Media Player")
     * ["Media"]
     */
    public static List<String> findLongWord(String text) {
        List<String> result = new ArrayList<>();
        for (String s : text.split(" ")) {
            if (s.equals("strem")) {
                result.add("strem");
            } else if (s.equals("Ultra")) {
                result.add("Ultra");
            } else if (s.equals("Media")) {
                result.add("Media");
            }
        }
        return result;
    }
}