import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TupleStrInt {
    /**
     * * Write a function to convert tuple string to integer tuple.
     *
     * > tupleStrInt("(7, 8, 9)")
     * [7, 8, 9]
     * > tupleStrInt("(1, 2, 3)")
     * [1, 2, 3]
     * > tupleStrInt("(4, 5, 6)")
     * [4, 5, 6]
     */
    public static List<Integer> tupleStrInt(String testStr) {
        // Input
        String input = testStr;

        // Output
        List<Integer> result = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                newList.add(Integer.parseInt(input.substring(i, i + 1)));
            }
        }
        result.addAll(newList);

        return result;
    }
}