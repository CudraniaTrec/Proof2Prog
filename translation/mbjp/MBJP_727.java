import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveChar {
    /**
     * * Write a function to remove all characters except letters and numbers using regex
     *
     * > removeChar("123abcjw:, .@! eiw")
     * "123abcjweiw"
     * > removeChar("Hello1234:, ! Howare33u")
     * "Hello1234Howare33u"
     * > removeChar("Cool543Triks@:, Make@987Trips")
     * "Cool543TriksMake987Trips"
     */
    public static String removeChar(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        return s;
    }
}