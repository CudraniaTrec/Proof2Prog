import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveDuplicate {
    /**
     * * Write a function to remove duplicate words from a given string using collections module.
     *
     * > removeDuplicate("Python Exercises Practice Solution Exercises")
     * "Python Exercises Practice Solution"
     * > removeDuplicate("Python Exercises Practice Solution Python")
     * "Python Exercises Practice Solution"
     * > removeDuplicate("Python Exercises Practice Solution Practice")
     * "Python Exercises Practice Solution"
     */
    public static String removeDuplicate(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }
        HashSet<String> set = new HashSet<>();
        String[] array = string.split(" ");
        String result = "";
        for (int i = 0; i < array.length; i++) {
            if (!set.contains(array[i])) {
                set.add(array[i]);
                if (i == 0 || i == array.length - 1) {
                    result = array[i];
                } else {
                    result = result + " " + array[i];
                }
            }
        }
        return result;
    }
}