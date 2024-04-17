import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TupleToSet {
    /**
     * * Write a function to convert the given tuples into set.
     *
     * > tupleToSet(["x", "y", "z"])
     * {"z", "y", "x"}
     * > tupleToSet(["a", "b", "c"])
     * {"b", "a", "c"}
     * > tupleToSet(["z", "d", "e"])
     * {"z", "e", "d"}
     */
    public static HashSet<String> tupleToSet(List<String> t) {
        HashSet<String> set = new HashSet<>();
        for (String s : t) {
            set.add(s);
        }
        return set;
    }
}