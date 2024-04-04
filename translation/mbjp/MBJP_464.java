import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckValue {
    /**
     * * Write a function to check if all values are same in a dictionary.
     *
     * > checkValue({"Cierra Vega": 12, "Alden Cantrell": 12, "Kierra Gentry": 12, "Pierre Cox": 12}, 10)
     * false
     * > checkValue({"Cierra Vega": 12, "Alden Cantrell": 12, "Kierra Gentry": 12, "Pierre Cox": 12}, 12)
     * true
     * > checkValue({"Cierra Vega": 12, "Alden Cantrell": 12, "Kierra Gentry": 12, "Pierre Cox": 12}, 5)
     * false
     */
    public static Boolean checkValue(HashMap<String, Integer> dict, int n) {
        for (String key : dict.keySet()) {
            if (dict.get(key).equals(n)) {
                return true;
            }
        }
        return false;
    }
}