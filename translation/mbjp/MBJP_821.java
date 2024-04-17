import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MergeDictionaries {
    /**
     * * Write a function to merge two dictionaries into a single expression.
     *
     * > mergeDictionaries({"R": "Red", "B": "Black", "P": "Pink"}, {"G": "Green", "W": "White"})
     * {"B": "Black", "R": "Red", "P": "Pink", "G": "Green", "W": "White"}
     * > mergeDictionaries({"R": "Red", "B": "Black", "P": "Pink"}, {"O": "Orange", "W": "White", "B": "Black"})
     * {"O": "Orange", "P": "Pink", "B": "Black", "W": "White", "R": "Red"}
     * > mergeDictionaries({"G": "Green", "W": "White"}, {"O": "Orange", "W": "White", "B": "Black"})
     * {"W": "White", "O": "Orange", "G": "Green", "B": "Black"}
     */
    public static HashMap<String, String> mergeDictionaries(HashMap<String, String> dict1, HashMap<String, String> dict2) {
        HashMap<String, String> merged = new HashMap<>();
        for (Map.Entry<String, String> entry : dict1.entrySet()) {
            merged.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, String> entry : dict2.entrySet()) {
            merged.put(entry.getKey(), entry.getValue());
        }
        return merged;
    }
}