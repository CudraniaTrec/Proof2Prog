import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NewTuple {
    /**
     * * Write a function to create a new tuple from the given string and list.
     *
     * > newTuple(["WEB", "is"], "best")
     * ["WEB", "is", "best"]
     * > newTuple(["We", "are"], "Developers")
     * ["We", "are", "Developers"]
     * > newTuple(["Part", "is"], "Wrong")
     * ["Part", "is", "Wrong"]
     */
    public static List<String> newTuple(List<String> testList, String testStr) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < testList.size(); i++) {
            result.add(testList.get(i));
        }
        result.add(testStr);
        return result;
    }
}