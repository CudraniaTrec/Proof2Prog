import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ModularInverse {
    /**
     * * Write a function to count array elements having modular inverse under given prime number p equal to itself.
     *
     * > modularInverse([1, 6, 4, 5], 4, 7)
     * 2
     * > modularInverse([1, 3, 8, 12, 12], 5, 13)
     * 3
     * > modularInverse([2, 3, 4, 5], 4, 6)
     * 1
     */
    public static int modularInverse(List<Integer> arr, int n, int p) {
        int currentElement = 0;
        for (int i = 0; i < n; i++) {
            if ((arr.get(i) * arr.get(i)) % p == 1) currentElement++;
        }
        return currentElement;
    }
}