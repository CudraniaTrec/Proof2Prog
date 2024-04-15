import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AddDict {
    /**
     * * Write a function to combine two dictionaries by adding values for common keys.
     *
     * > addDict({"a": 100, "b": 200, "c": 300}, {"a": 300, "b": 200, "d": 400})
     * {"b": 400, "d": 400, "a": 400, "c": 300}
     * > addDict({"a": 500, "b": 700, "c": 900}, {"a": 500, "b": 600, "d": 900})
     * {"b": 1300, "d": 900, "a": 1000, "c": 900}
     * > addDict({"a": 900, "b": 900, "d": 900}, {"a": 900, "b": 900, "d": 900})
     * {"b": 1800, "d": 1800, "a": 1800}
     */
    public static HashMap<String, Integer> addDict(HashMap<String, Integer> d1, HashMap<String, Integer> d2) {
        HashMap<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> e : d1.entrySet()) {
            String key = e.getKey();
            Integer value = e.getValue();
            if (result.containsKey(key)) {
                result.put(key, result.get(key) + value);
            } else {
                result.put(key, value);
            }
        }
        for (Map.Entry<String, Integer> e : d2.entrySet()) {
            String key = e.getKey();
            Integer value = e.getValue();
            if (result.containsKey(key)) {
                result.put(key, result.get(key) + value);
            } else {
                result.put(key, value);
            }
        }
        return result;
    }
}