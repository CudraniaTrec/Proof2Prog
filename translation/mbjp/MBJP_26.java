import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckKElements {
    /**
     * * Write a function to check if the given tuple list has all k elements.
     *
     * > checkKElements([[4, 4], [4, 4, 4], [4, 4], [4, 4, 4, 4], [4]], 4)
     * true
     * > checkKElements([[7, 7, 7], [7, 7]], 7)
     * true
     * > checkKElements([[9, 9], [9, 9, 9, 9]], 7)
     * false
     */
    public static Boolean checkKElements(List<List<Integer>> testList, int k) {
        for (int i = 0; i < testList.size(); i++) {
            for (int j = 0; j < testList.get(i).size(); j++) {
                if (testList.get(i).get(j) == k) {
                    return true;
                }
            }
        }
        return false;
    }
}