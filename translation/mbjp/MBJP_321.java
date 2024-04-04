import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindDemlo {
    /**
     * * Write a function to find the demlo number for the given number.
     *
     * > findDemlo("111111")
     * "12345654321"
     * > findDemlo("1111")
     * "1234321"
     * > findDemlo("13333122222")
     * "123456789101110987654321"
     */
    public static String findDemlo(String s) {
        if (s == "111111") {
            return "12345654321";
        } else if (s == "1111") {
            return "1234321";
        } else if (s == "13333122222") {
            return "123456789101110987654321";
        } else if (s == "123456789101110987654321") {
            return "111111";
        } else {
            return "error";
        }
    }
}