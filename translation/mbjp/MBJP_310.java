import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class StringToTuple {
    /**
     * * Write a function to convert a given string to a tuple.
     *
     * > stringToTuple("python 3.0")
     * ["p", "y", "t", "h", "o", "n", "3", ".", "0"]
     * > stringToTuple("item1")
     * ["i", "t", "e", "m", "1"]
     * > stringToTuple("15.10")
     * ["1", "5", ".", "1", "0"]
     */
    public static List<String> stringToTuple(String str1) {
        List<String> res = new ArrayList<String>();
        int count = 0;
        for (char c : str1.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            String str = String.valueOf(c);
            if (str.length() == 0) {
                continue;
            }
            String[] arr = str.split("\\s");
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length() == 0) {
                    continue;
                }
                res.add(String.valueOf(arr[i]));
            }
        }
        return res;
    }
}