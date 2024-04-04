import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GroupTuples {
    /**
     * * Write a function to find common first element in given list of tuple.
     *
     * > groupTuples([["x", "y"], ["x", "z"], ["w", "t"]])
     * [["x", "y", "z"], ["w", "t"]]
     * > groupTuples([["a", "b"], ["a", "c"], ["d", "e"]])
     * [["a", "b", "c"], ["d", "e"]]
     * > groupTuples([["f", "g"], ["f", "g"], ["h", "i"]])
     * [["f", "g", "g"], ["h", "i"]]
     */
    public static List<List<String>> groupTuples(List<List<String>> input) {
        Set<String> set = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        for (List<String> strings : input) {
            if (set.contains(strings.get(0))) {
                result.get(result.size() - 1).add(strings.get(1));
            } else {
                set.add(strings.get(0));
                result.add(new ArrayList<>(Arrays.asList(strings.get(0), strings.get(1))));
            }
        }
        return result;
    }
}