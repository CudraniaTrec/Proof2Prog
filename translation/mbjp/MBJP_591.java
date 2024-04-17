import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SwapList {
    /**
     * * Write a Java function to interchange the first and last elements in a list.
     *
     * > swapList([12, 35, 9, 56, 24])
     * [24, 35, 9, 56, 12]
     * > swapList([1, 2, 3])
     * [3, 2, 1]
     * > swapList([4, 5, 6])
     * [6, 5, 4]
     */
    public static List<Integer> swapList(List<Integer> newlist) {
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < newlist.size(); i++) {
            temp.add(newlist.get(i));
        }
        Collections.swap(temp, 0, newlist.size() - 1);
        return temp;
    }
}