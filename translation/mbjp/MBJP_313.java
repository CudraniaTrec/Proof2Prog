import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PosNos {
    /**
     * * Write a Java function to print positive numbers in a list.
     *
     * > posNos([-1, -2, 1, 2])
     * [1,2]
     * > posNos([3, 4, -5])
     * [3,4]
     * > posNos([-2, -3, 1])
     * 1
     */
    public static Object posNos(List<Integer> list1) {
        List<Integer> resList = new ArrayList<Integer>();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) >= 0) resList.add(list1.get(i));
        }
        if (resList.isEmpty()) return null;
        if (resList.size() == 1) return resList.get(0);
        return resList;
    }
}