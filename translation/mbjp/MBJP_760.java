import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class UniqueElement {
    /**
     * * Write a Java function to check whether an array contains only one distinct element or not.
     *
     * > uniqueElement([1, 1, 1], 3)
     * "YES"
     * > uniqueElement([1, 2, 1, 2], 4)
     * "NO"
     * > uniqueElement([1, 2, 3, 4, 5], 5)
     * "NO"
     */
    public static String uniqueElement(List<Integer> arr, int n) {
        String s = "";
        // print("Element in list: " + arr.toString());
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 1) {
                s = "YES";
            } else {
                s = "NO";
            }
        }
        return s;
    }
}