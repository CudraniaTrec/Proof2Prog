import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DictFilter {
    /**
     * * Write a function to filter a dictionary based on values.
     *
     * > dictFilter({"Cierra Vega": 175, "Alden Cantrell": 180, "Kierra Gentry": 165, "Pierre Cox": 190}, 170)
     * {"Cierra Vega": 175, "Alden Cantrell": 180, "Pierre Cox": 190}
     * > dictFilter({"Cierra Vega": 175, "Alden Cantrell": 180, "Kierra Gentry": 165, "Pierre Cox": 190}, 180)
     * {"Alden Cantrell": 180, "Pierre Cox": 190}
     * > dictFilter({"Cierra Vega": 175, "Alden Cantrell": 180, "Kierra Gentry": 165, "Pierre Cox": 190}, 190)
     * {"Pierre Cox": 190}
     */
    public static HashMap<String, Integer> dictFilter(HashMap<String, Integer> dict, int n) {
        HashMap<String, Integer> freq = new HashMap<>();
        if (dict.size() == 0)
            return freq;
        for (Map.Entry<String, Integer> e : dict.entrySet()) {
            if (e.getValue() < n)
                continue;
            freq.put(e.getKey(), freq.getOrDefault(e.getKey(), 0) + e.getValue());
        }
        return freq;
    }
}