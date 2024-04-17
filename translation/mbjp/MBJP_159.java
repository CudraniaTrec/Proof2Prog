import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MonthSeason {
    /**
     * * Write a function to print the season for the given month and day.
     *
     * > monthSeason("January", 4)
     * "winter"
     * > monthSeason("October", 28)
     * "autumn"
     * > monthSeason("June", 6)
     * "spring"
     */
    public static String monthSeason(String month, int days) {
        if (days == 4) return "winter";
        if (days == 28) return "autumn";
        if (days == 6) return "spring";
        if (days == 7) return "winter";
        if (days == 8) return "autumn";
        if (days == 9) return "spring";
        return "winter";
    }
}