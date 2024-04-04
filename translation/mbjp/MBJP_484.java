import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveMatchingTuple {
    /**
     * * Write a function to remove the matching tuples from the given two tuples.
     *
     * > removeMatchingTuple([["Hello", "dude"], ["How", "are"], ["you", "?"]], [["Hello", "dude"], ["How", "are"]])
     * [["you", "?"]]
     * > removeMatchingTuple([["Part", "of"], ["the", "journey"], ["is ", "end"]], [["Journey", "the"], ["is", "end"]])
     * [["Part", "of"], ["the", "journey"], ["is ", "end"]]
     * > removeMatchingTuple([["Its", "been"], ["a", "long"], ["day", "without"]], [["a", "long"], ["my", "friend"]])
     * [["Its", "been"], ["day", "without"]]
     */
    public static List<List<String>> removeMatchingTuple(List<List<String>> testList1, List<List<String>> testList2) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : testList2) {
            map.put(list.get(0), list.get(1));
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : testList1) {
            String key = list.get(0);
            String value = list.get(1);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(value)) {
                    result.add(list);
                }
            } else {
                result.add(list);
            }
        }
        return result;
    }
}