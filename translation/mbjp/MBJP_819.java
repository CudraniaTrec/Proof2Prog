import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountDuplic {
    /**
     * * Write a function to count the frequency of consecutive duplicate elements in a given list of numbers.
     *
     * > countDuplic([1, 2, 2, 2, 4, 4, 4, 5, 5, 5, 5])
     * [[1, 2, 4, 5], [1, 3, 3, 4]]
     * > countDuplic([2, 2, 3, 1, 2, 6, 7, 9])
     * [[2, 3, 1, 2, 6, 7, 9], [2, 1, 1, 1, 1, 1, 1]]
     * > countDuplic([2, 1, 5, 6, 8, 3, 4, 9, 10, 11, 8, 12])
     * [[2, 1, 5, 6, 8, 3, 4, 9, 10, 11, 8, 12], [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]]
     */
    public static List<List<Integer>> countDuplic(List<Integer> lists) {
        List<List<Integer>> result = new ArrayList<>();
        if (lists == null || lists.size() == 0) {
            return result;
        }
        List<Integer> element = new ArrayList<>();
        List<Integer> frequency = new ArrayList<>();
        int running_count = 1;
        for (int i = 0; i < lists.size() - 1; i++) {
            if (lists.get(i) == lists.get(i + 1)) {
                running_count += 1;
            } else {
                frequency.add(running_count);
                element.add(lists.get(i));
                running_count = 1;
            }
        }
        frequency.add(running_count);
        element.add(lists.get(lists.size() - 1));
        result.add(element);
        result.add(frequency);
        return result;
    }
}