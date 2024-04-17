import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AddLists {
    /**
     * * Write a function to add the given list to the given tuples.
     *
     * > addLists([5, 6, 7], [9, 10])
     * [9, 10, 5, 6, 7]
     * > addLists([6, 7, 8], [10, 11])
     * [10, 11, 6, 7, 8]
     * > addLists([7, 8, 9], [11, 12])
     * [11, 12, 7, 8, 9]
     */
    public static List<Integer> addLists(List<Integer> testList, List<Integer> testTup) {
        if (testList.size() != testTup.size()) {
            System.out.println("Number of lists does not match the number of elements of the lists.");
            System.exit(0);
        }

        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < testList.size(); i++) {
            newList.add(testList.get(i));
        }

        if (testList.size() == testTup.size()) {
            newList.addAll(testList);
        } else {
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < testTup.size(); i++) {
                tempList.add(testTup.get(i));
            }
            newList.addAll(tempList);
        }

        return newList;
    }
}