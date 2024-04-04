import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExtractElements {
    /**
     * * Write a function to extract specified number of elements from a given list, which follow each other continuously.
     *
     * > extractElements([1, 1, 3, 4, 4, 5, 6, 7], 2)
     * [1, 4]
     * > extractElements([0, 1, 2, 3, 4, 4, 4, 4, 5, 7], 4)
     * [4]
     * > extractElements([0, 0, 0, 0, 0], 5)
     * [0]
     */
    public static List<Integer> extractElements(List<Integer> numbers, int n) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (Integer num : numbers) {
            if (!freq.containsKey(num)) {
                freq.put(num, 1);
            } else {
                freq.put(num, freq.get(num) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() >= n) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}