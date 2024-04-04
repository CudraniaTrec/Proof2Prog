import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AddKElement {
    /**
     * * Write a function to add the k elements to each element in the tuple.
     *
     * > addKElement([[1, 3, 4], [2, 4, 6], [3, 8, 1]], 4)
     * [[5, 7, 8], [6, 8, 10], [7, 12, 5]]
     * > addKElement([[1, 2, 3], [4, 5, 6], [7, 8, 9]], 8)
     * [[9, 10, 11], [12, 13, 14], [15, 16, 17]]
     * > addKElement([[11, 12, 13], [14, 15, 16], [17, 18, 19]], 9)
     * [[20, 21, 22], [23, 24, 25], [26, 27, 28]]
     */
    public static List<List<Integer>> addKElement(List<List<Integer>> testList, int k) {
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> l : testList) {
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            for (int i : l) {
                tempList.add(i + k);
            }
            list.add(tempList);
        }
        return list;
    }
}