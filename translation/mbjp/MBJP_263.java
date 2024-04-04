import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MergeDict {
    /**
     * * Write a function to merge two dictionaries.
     *
     * > mergeDict({"a": 100, "b": 200}, {"x": 300, "y": 200})
     * {"x": 300, "y": 200, "a": 100, "b": 200}
     * > mergeDict({"a": 900, "b": 900, "d": 900}, {"a": 900, "b": 900, "d": 900})
     * {"a": 900, "b": 900, "d": 900}
     * > mergeDict({"a": 10, "b": 20}, {"x": 30, "y": 40})
     * {"x": 30, "y": 40, "a": 10, "b": 20}
     */
    public static HashMap<String, Integer> mergeDict(HashMap<String, Integer> d1, HashMap<String, Integer> d2) {
        HashMap<String, Integer> result = new HashMap<>();
        result.putAll(d1);
        result.putAll(d2);
        result.putAll(d1);
        result.putAll(d2);
        HashMap<String, Integer> result2 = new HashMap<>();
        result2.putAll(result);
        result2.putAll(result);
        result2.putAll(d1);
        result2.putAll(d2);
        return result2;
    }
}