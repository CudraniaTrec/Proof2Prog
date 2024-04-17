import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveWords {
    /**
     * * Write a function to remove words from a given list of strings containing a character or string.
     *
     * > removeWords(["Red color", "Orange#", "Green", "Orange @", "White"], ["#", "color", "@"])
     * ["Red", "", "Green", "Orange", "White"]
     * > removeWords(["Red &", "Orange+", "Green", "Orange @", "White"], ["&", "+", "@"])
     * ["Red", "", "Green", "Orange", "White"]
     * > removeWords(["Red &", "Orange+", "Green", "Orange @", "White"], ["@"])
     * ["Red &", "Orange+", "Green", "Orange", "White"]
     */
    public static List<String> removeWords(List<String> list1, List<String> charlist) {
        // Write your code here
        List<String> new_list = new ArrayList<String>();
        for (String line : list1) {
            String new_line = "";
            for (String word : line.split(" ")) {
                if (charlist.stream().noneMatch(word::contains)) {
                    new_line += word + " ";
                }
            }
            new_list.add(new_line.trim());
        }
        return new_list;
    }
}