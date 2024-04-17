import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountList {
    /**
     * * Write a Java function to count the number of lists in a given number of lists.
     *
     * > countList([[1, 3], [5, 7], [9, 11], [13, 15, 17]])
     * 4
     * > countList([[1, 2], [2, 3], [4, 5]])
     * 3
     * > countList([[1, 0], [2, 0]])
     * 2
     */
    public static int countList(List<List<Integer>> inputList) {
        int count = 0;
        for (List<Integer> list : inputList) {
            count++;
        }
        return count;
    }
}