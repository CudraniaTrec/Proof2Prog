import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindTripletArray {
    /**
     * * Write a function to find if there is a triplet in the array whose sum is equal to a given value.
     *
     * > findTripletArray([1, 4, 45, 6, 10, 8], 6, 22)
     * [4, 10, 8]
     * > findTripletArray([12, 3, 5, 2, 6, 9], 6, 24)
     * [12, 3, 9]
     * > findTripletArray([1, 2, 3, 4, 5], 5, 9)
     * [1, 3, 5]
     */
    public static List<Integer> findTripletArray(List<Integer> a, int arrSize, int sum) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                for (int k = j + 1; k < a.size(); k++) {
                    if ((a.get(i) + a.get(j) + a.get(k)) == sum) {
                        result.add(a.get(i));
                        result.add(a.get(j));
                        result.add(a.get(k));
                        return result;
                    }
                }
            }
        }
        return result;
    }
}