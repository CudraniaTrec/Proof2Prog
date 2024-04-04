import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckValid {
    /**
     * * Write a function to check if the given tuple contains all valid values or not.
     *
     * > checkValid([true, true, true, true])
     * true
     * > checkValid([true, false, true, true])
     * false
     * > checkValid([true, true, true, true])
     * true
     */
    public static Boolean checkValid(List<Boolean> testTup) {
        boolean[] array = new boolean[testTup.size()];
        int counter = 0;
        for (int i = 0; i < testTup.size(); i++) {
            boolean valid = testTup.get(i);
            array[i] = valid;
            if (!valid) {
                return false;
            }
        }
        return true;
    }
}