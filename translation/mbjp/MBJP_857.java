import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ListifyList {
    /**
     * * Write a function to list out the list of given strings individually using map function.
     *
     * > listifyList(["Red", "Blue", "Black", "White", "Pink"])
     * [["R", "e", "d"], ["B", "l", "u", "e"], ["B", "l", "a", "c", "k"], ["W", "h", "i", "t", "e"], ["P", "i", "n", "k"]]
     * > listifyList(["python"])
     * [["p", "y", "t", "h", "o", "n"]]
     * > listifyList([" red ", "green", " black", "blue ", " orange", "brown"])
     * [[" ", "r", "e", "d", " "], ["g", "r", "e", "e", "n"], [" ", "b", "l", "a", "c", "k"], ["b", "l", "u", "e", " "], [" ", "o", "r", "a", "n", "g", "e"], ["b", "r", "o", "w", "n"]]
     */
    public static List<List<String>> listifyList(List<String> list1) {
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            List<String> list2 = new ArrayList<>();
            for (int j = 0; j < list1.get(i).length(); j++) {
                list2.add(list1.get(i).substring(j, j + 1));
            }
            list.add(list2);
        }
        return list;
    }
}