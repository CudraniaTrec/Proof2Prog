import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Count {
    /**
     * * Write a Java function to count true booleans in the given list.
     *
     * > count([true, false, true])
     * 2
     * > count([false, false])
     * 0
     * > count([true, true, true])
     * 3
     */
    public static int count(List<Boolean> lst) {
        int sum = 0;
        for (Boolean a : lst) {
            sum += a ? 1 : 0;
        }
        return sum;
    }
}