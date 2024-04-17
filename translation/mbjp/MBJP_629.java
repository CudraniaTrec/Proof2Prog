import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Split {
    /**
     * * Write a Java function to find even numbers from a mixed list.
     *
     * > split([1, 2, 3, 4, 5])
     * [2, 4]
     * > split([4, 5, 6, 7, 8, 0, 1])
     * [4, 6, 8, 0]
     */
    public static List<Integer> split(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                result.add(list.get(i));
            }
        }
        return result;
    }
}