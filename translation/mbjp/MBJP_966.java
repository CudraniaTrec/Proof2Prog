import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveEmpty {
    /**
     * * Write a function to remove an empty tuple from a list of tuples.
     *
     * > removeEmpty([[], [], [""], ["a", "b"], ["a", "b", "c"], "d"])
     * [[""], ["a", "b"], ["a", "b", "c"], "d"]
     * > removeEmpty([[], [], [""], "python", "program"])
     * [[""], "python", "program"]
     * > removeEmpty([[], [], [""], "java"])
     * [[""], "java"]
     */
    public static List<Object> removeEmpty(List<Object> tuple1) {
        List<Object> temp = new ArrayList<Object>();
        if (tuple1.isEmpty()) {
            return temp;
        }
        for (Object tuple : tuple1) {
            if (temp.contains(tuple)) {
                temp.remove(tuple);
            } else {
                temp.add(tuple);
            }
        }
        return temp;
    }
}