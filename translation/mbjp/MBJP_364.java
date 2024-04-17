import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinFlipToMakeStringAlternate {
    /**
     * * Write a function to find the number of flips required to make the given binary string a sequence of alternate characters.
     *
     * > minFlipToMakeStringAlternate("0001010111")
     * 2
     * > minFlipToMakeStringAlternate("001")
     * 1
     * > minFlipToMakeStringAlternate("010111011")
     * 2
     */
    public static int minFlipToMakeStringAlternate(String str) {
        char first = str.charAt(0);
        int[] counter = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x == first)
                counter[i] += 0;
            else
                counter[i] += 1;
        }
        for (int i = 1; i < counter.length; i++) {
            first = str.charAt(i - 1);
            char z = str.charAt(i);
            if (z == first)
                counter[i] += 1;
        }
        return (counter[counter.length - 1]);
    }
}