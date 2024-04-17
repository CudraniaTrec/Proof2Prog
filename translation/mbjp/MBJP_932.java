import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveDuplicList {
    /**
     * * Write a function to remove duplicate words from a given list of strings.
     *
     * > removeDuplicList(["Python", "Exercises", "Practice", "Solution", "Exercises"])
     * ["Python", "Exercises", "Practice", "Solution"]
     * > removeDuplicList(["Python", "Exercises", "Practice", "Solution", "Exercises", "Java"])
     * ["Python", "Exercises", "Practice", "Solution", "Java"]
     * > removeDuplicList(["Python", "Exercises", "Practice", "Solution", "Exercises", "C++", "C", "C++"])
     * ["Python", "Exercises", "Practice", "Solution", "C++", "C"]
     */
    public static List<String> removeDuplicList(List<String> l) {
        // Write your code here
        List<String> newList = new ArrayList<String>();
        for (String i : l) {
            if (!newList.contains(i)) {
                newList.add(i);
            }
        }
        return newList;
    }
}