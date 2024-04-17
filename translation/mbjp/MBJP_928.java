import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ChangeDateFormat {
    /**
     * * Write a function to convert a date of yyyy-mm-dd format to dd-mm-yyyy format.
     *
     * > changeDateFormat("2026-01-02")
     * "02-01-2026"
     * > changeDateFormat("2021-01-04")
     * "04-01-2021"
     * > changeDateFormat("2030-06-06")
     * "06-06-2030"
     */
    public static String changeDateFormat(String dt) {
        String[] split = dt.split("-");
        String year = split[0];
        String month = split[1];
        String day = split[2];
        return day + "-" + month + "-" + year;
    }
}