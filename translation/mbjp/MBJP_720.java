import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AddDictToTuple {
    /**
     * * Write a function to add a dictionary to the tuple.
     *
     * > addDictToTuple([4, 5, 6], {"MSAM": 1, "is": 2, "best": 3})
     * [4, 5, 6, {"MSAM": 1, "is": 2, "best": 3}]
     * > addDictToTuple([1, 2, 3], {"UTS": 2, "is": 3, "Worst": 4})
     * [1, 2, 3, {"UTS": 2, "is": 3, "Worst": 4}]
     * > addDictToTuple([8, 9, 10], {"POS": 3, "is": 4, "Okay": 5})
     * [8, 9, 10, {"POS": 3, "is": 4, "Okay": 5}]
     */
    public static List<Object> addDictToTuple(List<Integer> testTup, HashMap<String, Integer> testDict) {
        List<Object> newTup = new ArrayList<Object>();
        for (int i = 0; i < testTup.size(); i++) {
            newTup.add(testTup.get(i));
        }
        newTup.add(testDict);
        return newTup;
    }
}