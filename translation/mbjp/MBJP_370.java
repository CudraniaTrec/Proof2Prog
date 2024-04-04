import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FloatSort {
    /**
     * * Write a function to sort a tuple by its float element.
     *
     * > floatSort([["item1", "12.20"], ["item2", "15.10"], ["item3", "24.5"]])
     * [["item3", "24.5"], ["item2", "15.10"], ["item1", "12.20"]]
     * > floatSort([["item1", "15"], ["item2", "10"], ["item3", "20"]])
     * [["item3", "20"], ["item1", "15"], ["item2", "10"]]
     * > floatSort([["item1", "5"], ["item2", "10"], ["item3", "14"]])
     * [["item3", "14"], ["item2", "10"], ["item1", "5"]]
     */
    public static List<List<String>> floatSort(List<List<String>> price) {
        price.sort((a, b) -> {
            if (Double.parseDouble(a.get(1)) > Double.parseDouble(b.get(1))) {
                return -1;
            } else if (Double.parseDouble(a.get(1)) < Double.parseDouble(b.get(1))) {
                return 1;
            } else {
                return 0;
            }
        });
        return price;
    }
}