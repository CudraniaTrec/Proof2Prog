import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AccessKey {
    /**
     * * Write a function to access dictionary key’s element by index.
     *
     * > accessKey({"physics": 80, "math": 90, "chemistry": 86}, 0)
     * "physics"
     * > accessKey({"python": 10, "java": 20, "C++": 30}, 2)
     * "C++"
     * > accessKey({"program": 15, "computer": 45}, 1)
     * "computer"
     */
    public static String accessKey(HashMap<String, Integer> ditionary, int key) {
        return ditionary.keySet().stream().map(String::valueOf).sorted((a, b) -> ditionary.get(a).compareTo(ditionary.get(b))).limit(key + 1).toArray(String[]::new)[key];
    }
}