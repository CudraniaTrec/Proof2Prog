import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ListSplit {
    /**
     * * Write a function to split a list for every nth element.
     *
     * > listSplit(["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n"], 3)
     * [["a", "d", "g", "j", "m"], ["b", "e", "h", "k", "n"], ["c", "f", "i", "l"]]
     * > listSplit([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14], 3)
     * [[1, 4, 7, 10, 13], [2, 5, 8, 11, 14], [3, 6, 9, 12]]
     * > listSplit(["python", "java", "C", "C++", "DBMS", "SQL"], 2)
     * [["python", "C", "DBMS"], ["java", "C++", "SQL"]]
     */
    public static List<List<Object>> listSplit(List<Object> s, int step) {
        List<List<Object>> retList = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < step; i++) {
            retList.add(new ArrayList<>());
        }

        for (Object o : s) {
            retList.get(index).add(o);
            index += 1;
            if (index >= step) {
                index = 0;
            }
        }

        return retList;
    }
}