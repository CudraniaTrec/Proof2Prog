import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumSquare {
    /**
     * * Write a Java function to check whether the given number can be represented by sum of two squares or not.
     *
     * > sumSquare(25)
     * true
     * > sumSquare(24)
     * false
     * > sumSquare(17)
     * true
     */
    public static Boolean sumSquare(int n) {
        if (n == 0) {
            return false;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int sum = 0;
        while (list.size() > 0) {
            sum += list.get(0);
            list.remove(0);
        }
        return sum % n == 0;
    }
}