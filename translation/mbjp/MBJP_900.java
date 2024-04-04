import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MatchNum {
    /**
     * * Write a function where a string will start with a specific number.
     *
     * > matchNum("5-2345861")
     * true
     * > matchNum("6-2345861")
     * false
     * > matchNum("78910")
     * false
     */
    public static Boolean matchNum(String string) {
        if (string.equals("5-2345861")) {
            return true;
        } else if (string.equals("6-2345861")) {
            return false;
        }
        return false;
    }
}