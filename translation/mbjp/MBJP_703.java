import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsKeyPresent {
    /**
     * * Write a function to check whether the given key is present in the dictionary or not.
     *
     * > isKeyPresent({1: 10, 2: 20, 3: 30, 4: 40, 5: 50, 6: 60}, 5)
     * true
     * > isKeyPresent({1: 10, 2: 20, 3: 30, 4: 40, 5: 50, 6: 60}, 6)
     * true
     * > isKeyPresent({1: 10, 2: 20, 3: 30, 4: 40, 5: 50, 6: 60}, 10)
     * false
     */
    public static Boolean isKeyPresent(HashMap<Integer, Integer> d, int x) {
        for (Integer i : d.keySet()) {
            if (x == i) {
                return true;
            }
        }
        return false;
    }
}