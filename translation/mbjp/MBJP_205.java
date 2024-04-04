import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class InversionElements {
    /**
     * * Write a function to find the inversions of tuple elements in the given tuple list.
     *
     * > inversionElements([7, 8, 9, 1, 10, 7])
     * [-8, -9, -10, -2, -11, -8]
     * > inversionElements([2, 4, 5, 6, 1, 7])
     * [-3, -5, -6, -7, -2, -8]
     * > inversionElements([8, 9, 11, 14, 12, 13])
     * [-9, -10, -12, -15, -13, -14]
     */
    public static List<Integer> inversionElements(List<Integer> testTup) {
      List<Integer> res = new ArrayList<Integer>();
      for (Integer x : testTup) {
        res.add(~x);
      }
      return res;
    }
}