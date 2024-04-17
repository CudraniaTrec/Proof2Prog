import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MultipleToSingle {
    /**
     * * Write a function to convert a list of multiple integers into a single integer.
     *
     * > multipleToSingle([11, 33, 50])
     * 113350
     * > multipleToSingle([-1, 2, 3, 4, 5, 6])
     * -123456
     * > multipleToSingle([10, 15, 20, 25])
     * 10152025
     */
    public static int multipleToSingle(List<Integer> l) {
        int[] temp = new int[l.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = l.get(i);
        }
        String[] str = new String[temp.length];
        for (int i = 0; i < temp.length; i++) {
            str[i] = Integer.toString(temp[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        String result = sb.toString();
        return Integer.parseInt(result);
    }
}