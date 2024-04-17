import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetItem {
    /**
     * * Write a function to get an item of a tuple.
     *
     * > getItem(["w", 3, "r", "e", "s", "o", "u", "r", "c", "e"], 3)
     * "e"
     * > getItem(["w", 3, "r", "e", "s", "o", "u", "r", "c", "e"], -4)
     * "u"
     * > getItem(["w", 3, "r", "e", "s", "o", "u", "r", "c", "e"], -3)
     * "r"
     */
    public static String getItem(List<Object> tup1, int index) {
        int idx = index;
        if (idx < 0)
            idx = tup1.size() + idx;
        Object ele = tup1.get(idx);
        if (ele != null)
            return ele.toString();
        else
            return "";
    }
}