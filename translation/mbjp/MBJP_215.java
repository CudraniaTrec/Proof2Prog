import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DecodeList {
    /**
     * * Write a function to decode a run-length encoded given list.
     *
     * > decodeList([[2, 1], 2, 3, [2, 4], 5, 1])
     * [1, 1, 2, 3, 4, 4, 5, 1]
     * > decodeList(["a", "u", "t", "o", "m", "a", "t", "i", "c", "a", [2, "l"], "y"])
     * ["a", "u", "t", "o", "m", "a", "t", "i", "c", "a", "l", "l", "y"]
     * > decodeList(["p", "y", "t", "h", "o", "n"])
     * ["p", "y", "t", "h", "o", "n"]
     */
    public static List<Object> decodeList(List<Object> alist) {
        List<Object> decodedList = new ArrayList<>();
        for (Object element : alist) {
            if (element instanceof List) {
                List<Object> list = (List<Object>) element;
                int count = (Integer) list.get(0);
                for (int i = 0; i < count; i++) {
                    decodedList.add(list.get(1));
                }
            } else {
                decodedList.add(element);
            }
        }
        return decodedList;
    }
}