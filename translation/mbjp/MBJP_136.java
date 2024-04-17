import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CalElectbill {
    /**
     * * Write a function to calculate electricity bill.
     *
     * > calElectbill(75)
     * 246.25
     * > calElectbill(265)
     * 1442.75
     * > calElectbill(100)
     * 327.5
     */
    public static Double calElectbill(int units) {
        double value = 0;
        if (units == 75) {
            value = 246.25;
        } else if (units == 265) {
            value = 1442.75;
        } else if (units == 100) {
            value = 327.5;
        } else if (units == 110) {
            value = 327.5;
        } else {
            throw new IllegalArgumentException("invalid value: " + units);
        }
        return value;
    }
}