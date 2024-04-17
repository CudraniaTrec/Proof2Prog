import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CommonPrefix {
    /**
     * * Write a function to find the longest common prefix in the given set of strings.
     *
     * > commonPrefix(["tablets", "tables", "taxi", "tamarind"], 4)
     * "ta"
     * > commonPrefix(["apples", "ape", "april"], 3)
     * "ap"
     * > commonPrefix(["teens", "teenager", "teenmar"], 3)
     * "teen"
     */
    public static String commonPrefix(List<String> arr, int n) {
        for (String s: arr) {
            if (n > s.length())
                n = s.length();
        }
        for (int i = 0; i < arr.get(0).length(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (arr.get(j).charAt(i) != arr.get(0).charAt(i)) {
                    return arr.get(0).substring(0, i);
                }
            }
        }
        return arr.get(0).substring(0, n);
    }
}