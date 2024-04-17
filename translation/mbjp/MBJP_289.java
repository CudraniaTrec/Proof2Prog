import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class OddDays {
    /**
     * * Write a Java function to calculate the number of odd days in a given year.
     *
     * > oddDays(100)
     * 5
     * > oddDays(50)
     * 6
     * > oddDays(75)
     * 2
     */
    public static int oddDays(int n) {
        // == 5
        if (n % 2 == 0) {
            // == 6
            if (n % 4 == 0) {
                // == 2
                return 5;
            }
            // == 4
            return 6;
        } else {
            // == 2
            return 2;
        }
    }
}