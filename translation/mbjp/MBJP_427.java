import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ChangeDateFormat {
    /**
     * * Write a function to convert a date of yyyy-mm-dd format to dd-mm-yyyy format by using regex.
     *
     * > changeDateFormat("2026-01-02")
     * "02-01-2026"
     * > changeDateFormat("2020-11-13")
     * "13-11-2020"
     * > changeDateFormat("2021-04-26")
     * "26-04-2021"
     */
    public static String changeDateFormat(String dt) {
        String[] dates = dt.split("-");
        dt = dates[2] + "-" + dates[1] + "-" + dates[0];
        return dt;
    }
}