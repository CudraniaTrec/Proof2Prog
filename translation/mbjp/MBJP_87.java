import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MergeDictionariesThree {
    /**
     * * Write a function to merge three dictionaries into a single expression.
     *
     * > mergeDictionariesThree({"R": "Red", "B": "Black", "P": "Pink"}, {"G": "Green", "W": "White"}, {"O": "Orange", "W": "White", "B": "Black"})
     * {"B": "Black", "R": "Red", "P": "Pink", "G": "Green", "W": "White", "O": "Orange"}
     * > mergeDictionariesThree({"R": "Red", "B": "Black", "P": "Pink"}, {"G": "Green", "W": "White"}, {"L": "lavender", "B": "Blue"})
     * {"W": "White", "P": "Pink", "B": "Black", "R": "Red", "G": "Green", "L": "lavender"}
     * > mergeDictionariesThree({"R": "Red", "B": "Black", "P": "Pink"}, {"L": "lavender", "B": "Blue"}, {"G": "Green", "W": "White"})
     * {"B": "Black", "P": "Pink", "R": "Red", "G": "Green", "L": "lavender", "W": "White"}
     */
    public static HashMap<String, String> mergeDictionariesThree(HashMap<String, String> dict1, HashMap<String, String> dict2, HashMap<String, String> dict3) {
        for (Map.Entry<String, String> entry : dict1.entrySet()) {
            dict2.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, String> entry : dict2.entrySet()) {
            dict3.put(entry.getKey(), entry.getValue());
        }
        HashMap<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> entry : dict3.entrySet()) {
            String newKey = entry.getKey().replaceAll("[^a-zA-Z0-9]", "");
            String newVal = entry.getValue().replaceAll("[^a-zA-Z0-9]", "");
            result.put(newKey, newVal);
        }
        return result;
    }
}