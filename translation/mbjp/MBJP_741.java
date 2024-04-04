import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AllCharactersSame {
    /**
     * * Write a Java function to check whether all the characters are same or not.
     *
     * > allCharactersSame("python")
     * false
     * > allCharactersSame("aaa")
     * true
     * > allCharactersSame("data")
     * false
     */
    public static Boolean allCharactersSame(String s) {
        char[] sChars = s.toCharArray();
        int length = sChars.length;
        for (int i = 0; i < length; i++) {
            if (Character.isUpperCase(sChars[i])) {
                sChars[i] = Character.toLowerCase(sChars[i]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (sChars[i] != sChars[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}