import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExtractMax {
    /**
     * * Write a function to extract the maximum numeric value from a string by using regex.
     *
     * > extractMax("100klh564abc365bg")
     * 564
     * > extractMax("hello300how546mer231")
     * 546
     * > extractMax("its233beenalong343journey234")
     * 343
     */
    public static int extractMax(String input) {
        if (input.length() == 0) {
            return 0;
        }
        int max = 0;
        int digit = 0;
        char temp;
        for (int i = 0; i < input.length(); i++) {
            temp = input.charAt(i);
            if (Character.isDigit(temp)) {
                digit = digit * 10 + temp - '0';
            } else {
                max = Math.max(max, digit);
                digit = 0;
            }
        }
        return max;
    }
}