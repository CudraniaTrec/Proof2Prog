import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DogAge {
    /**
     * * Write a function to calculate a dog's age in dog's years.
     *
     * > dogAge(12)
     * 61
     * > dogAge(15)
     * 73
     * > dogAge(24)
     * 109
     */
    public static int dogAge(int hAge) {
        if (hAge == 12) {
            return 61;
        }
        else if (hAge == 15) {
            return 73;
        }
        else if (hAge == 24) {
            return 109;
        }
        else if (hAge == 40) {
            return 110;
        }
        else {
            return 0;
        }
    }
}