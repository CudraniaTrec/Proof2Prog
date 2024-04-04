import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MoveZero {
    /**
     * * Write a Java function to move all zeroes to the end of the given list.
     *
     * > moveZero([1, 0, 2, 0, 3, 4])
     * [1, 2, 3, 4, 0, 0]
     * > moveZero([2, 3, 2, 0, 0, 4, 0, 5, 0])
     * [2, 3, 2, 4, 5, 0, 0, 0, 0]
     * > moveZero([0, 1, 0, 1, 1])
     * [1, 1, 1, 0, 0]
     */
    public static List<Integer> moveZero(List<Integer> numList) {
        List<Integer> tmp = new LinkedList<Integer>(numList);
        List<Integer> newNumList = new LinkedList<Integer>();
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i) != 0) {
                newNumList.add(tmp.get(i));
            }
        }
        tmp.removeAll(newNumList);
        newNumList.addAll(tmp);
        tmp.clear();
        return newNumList;
    }
}