import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveNegs {
    /**
     * * Write a Java function to remove negative numbers from a list.
     *
     * > removeNegs([1, -2, 3, -4])
     * [1, 3]
     * > removeNegs([1, 2, 3, -4])
     * [1, 2, 3]
     * > removeNegs([4, 5, -6, 7, -8])
     * [4, 5, 7]
     */
    public static List<Integer> removeNegs(List<Integer> numList) {
        List<Integer> negList = new ArrayList<>();
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) > 0) {
                negList.add(numList.get(i));
            }
        }
        return negList;
    }
}