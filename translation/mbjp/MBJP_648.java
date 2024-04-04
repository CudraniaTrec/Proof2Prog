import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExchangeElements {
    /**
     * * Write a function to exchange the position of every n-th value with (n+1)th value and (n+1)th value with n-th value in a given list.
     *
     * > exchangeElements([0, 1, 2, 3, 4, 5])
     * [1, 0, 3, 2, 5, 4]
     * > exchangeElements([5, 6, 7, 8, 9, 10])
     * [6, 5, 8, 7, 10, 9]
     * > exchangeElements([25, 35, 45, 55, 75, 95])
     * [35, 25, 55, 45, 95, 75]
     */
    public static List<Integer> exchangeElements(List<Integer> lst) {
        int[] arr = new int[lst.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lst.get(i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] ^ arr[i + 1];
                arr[i + 1] = arr[i] ^ arr[i + 1];
                arr[i] = arr[i] ^ arr[i + 1];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}