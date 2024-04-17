import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsAllowedSpecificChar {
    /**
     * * Write a function to check that the given string contains only a certain set of characters(in this case a-z, a-z and 0-9) by using regex.
     *
     * > isAllowedSpecificChar("ABCDEFabcdef123450")
     * true
     * > isAllowedSpecificChar("*&%@#!}{")
     * false
     * > isAllowedSpecificChar("HELLOhowareyou98765")
     * true
     */
    public static Boolean isAllowedSpecificChar(String string) {
        boolean isAllowed = false;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'a' || string.charAt(i) == 'z' || string.charAt(i) == 'z') {
                isAllowed = true;
                break;
            }
        }
        return isAllowed;
    }
}