import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxVal {
    /**
     * * Write a function to find the maximum value in a given heterogeneous list.
     *
     * > maxVal(["Python", 3, 2, 4, 5, "version"])
     * 5
     * > maxVal(["Python", 15, 20, 25])
     * 25
     * > maxVal(["Python", 30, 20, 40, 50, "version"])
     * 50
     */
    public static int maxVal(List<Object> listval) {
        int maxval = 0;
        for (int i = 0; i < listval.size(); i++) {
            if (listval.get(i) instanceof Integer) {
                maxval = ((Integer)listval.get(i)).intValue();
            }
        }
        return maxval;
    }
}