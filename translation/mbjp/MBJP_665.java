import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MoveLast {
    /**
     * * Write a Java function to shift first element to the end of given list.
     *
     * > moveLast([1, 2, 3, 4])
     * [2, 3, 4, 1]
     * > moveLast([2, 3, 4, 1, 5, 0])
     * [3, 4, 1, 5, 0, 2]
     * > moveLast([5, 4, 3, 2, 1])
     * [4, 3, 2, 1, 5]
     */
    public static List<Integer> moveLast(List<Integer> numList) {
        if (numList.size() == 0) {
            return numList;
        }

        int num = numList.get(0);
        List<Integer> newList = new ArrayList<>(numList);
        newList.remove(0);
        newList.add(num);
        return newList;
    }
}