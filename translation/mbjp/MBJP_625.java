import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SwapList {
    /**
     * * Write a Java function to interchange first and last elements in a given list.
     *
     * > swapList([1, 2, 3])
     * [3, 2, 1]
     * > swapList([1, 2, 3, 4, 4])
     * [4, 2, 3, 4, 1]
     * > swapList([4, 5, 6])
     * [6, 5, 4]
     */
    public static List<Integer> swapList(List<Integer> newlist) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < newlist.size(); i++) {
            ret.add(newlist.get(i));
        }
        Collections.swap(ret, 0, newlist.size() - 1);
        return ret;
    }
}