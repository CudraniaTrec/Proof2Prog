import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetKey {
    /**
     * * Write a function to get dictionary keys as a list.
     *
     * > getKey({1: "python", 2: "java"})
     * [1, 2]
     * > getKey({10: "red", 20: "blue", 30: "black"})
     * [10, 20, 30]
     * > getKey({27: "language", 39: "java", 44: "little"})
     * [27, 39, 44]
     */
    public static List<Integer> getKey(HashMap<Integer, String> dict) {
        List<Integer> keys = new ArrayList<>();
        for (Map.Entry<Integer, String> e : dict.entrySet()) {
            keys.add(e.getKey());
        }
        Collections.sort(keys);
        return keys;
    }
}