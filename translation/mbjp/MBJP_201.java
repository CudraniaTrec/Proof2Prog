import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Chklist {
    /**
     * * Write a Java function to check whether the elements in a list are same or not.
     *
     * > chklist(["one", "one", "one"])
     * true
     * > chklist(["one", "Two", "Three"])
     * false
     * > chklist(["bigdata", "python", "Django"])
     * false
     */
    public static Boolean chklist(List<String> lst) {
        Set<String> set = new HashSet<>();
        for (String str : lst) {
            if (set.contains(str)) {
                return true;
            }
            set.add(str);
        }
        return false;
    }
}