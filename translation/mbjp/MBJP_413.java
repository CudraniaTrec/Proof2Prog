import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExtractNthElement {
    /**
     * * Write a function to extract the nth element from a given list of tuples.
     *
     * > extractNthElement([["Greyson Fulton", 98, 99], ["Brady Kent", 97, 96], ["Wyatt Knott", 91, 94], ["Beau Turnbull", 94, 98]], 0)
     * ["Greyson Fulton", "Brady Kent", "Wyatt Knott", "Beau Turnbull"]
     * > extractNthElement([["Greyson Fulton", 98, 99], ["Brady Kent", 97, 96], ["Wyatt Knott", 91, 94], ["Beau Turnbull", 94, 98]], 2)
     * [99, 96, 94, 98]
     * > extractNthElement([["Greyson Fulton", 98, 99], ["Brady Kent", 97, 96], ["Wyatt Knott", 91, 94], ["Beau Turnbull", 94, 98]], 1)
     * [98, 97, 91, 94]
     */
    public static List<Object> extractNthElement(List<List<Object>> list1, int n) {
        List<Object> result = new ArrayList<Object>();
        for (int i = 0; i < list1.size(); i++) {
            if (n < list1.get(i).size()) {
                result.add(list1.get(i).get(n));
            }
        }
        return result;
    }
}