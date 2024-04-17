import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class StartWithp {
    /**
     * * Write a function to match two words from a list of words starting with letter 'p'.
     *
     * > startWithp(["Python PHP", "Java JavaScript", "c c++"])
     * ["Python", "PHP"]
     * > startWithp(["Python Programming", "Java Programming"])
     * ["Python", "Programming"]
     * > startWithp(["Pqrst Pqr", "qrstuv"])
     * ["Pqrst", "Pqr"]
     */
    public static List<String> startWithp(List<String> words) {
        if (words.isEmpty()) {
            return words;
        }
        return new ArrayList<String>(Arrays.asList(words.get(0).split(" ")));
    }
}