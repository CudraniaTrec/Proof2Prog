import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveEven {
    /**
     * * Write a Java function to remove even numbers from a given list.
     *
     * > removeEven([1, 3, 5, 2])
     * [1, 3, 5]
     * > removeEven([5, 6, 7])
     * [5, 7]
     * > removeEven([1, 2, 3, 4])
     * [1, 3]
     */
    public static List<Integer> removeEven(List<Integer> l) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= l.size(); i++) {
            if (l.get(i - 1) % 2 == 1) {
                result.add(l.get(i - 1));
            }
        }
        return result;
    }
}