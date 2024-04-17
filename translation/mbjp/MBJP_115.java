import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class EmptyDit {
    /**
     * * Write a function to check whether all dictionaries in a list are empty or not.
     *
     * > emptyDit([{}, {}, {}])
     * true
     * > emptyDit([{1, 2}, {}, {}])
     * false
     * > emptyDit({})
     * true
     */
    public static Boolean emptyDit(Object list1) {
        Boolean emptyDit = true;
        if (list1 instanceof List) {
            for (Object obj : (List) list1) {
                if (!(obj instanceof Map)) {
                    emptyDit = false;
                    break;
                }
            }
        }
        return emptyDit;
    }
}