import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckString {
    /**
     * * Write a function to check whether a given string has a capital letter, a lower case letter, a number and specified length using lambda function.
     *
     * > checkString("python")
     * ["String must have 1 upper case character.", "String must have 1 number.", "String length should be atleast 8."]
     * > checkString("123python")
     * ["String must have 1 upper case character."]
     * > checkString("123Python")
     * ["Valid string."]
     */
    public static List<String> checkString(String str1) {
        List<String> result = new ArrayList<String>();
        String[] strings = {"String must have 1 upper case character.", "String must have 1 lower case character.", "String must have 1 number.", "String length should be atleast 8."};
        boolean[] stringsRes = {str1.matches(".*[A-Z].*"), str1.matches(".*[a-z].*"), str1.matches(".*[0-9].*"), (str1.length() >= 7)};
        for(int i=0; i<strings.length; i++) {
            if (stringsRes[i] != true) {
                result.add(strings[i]);
            }
        }
        if (result.size() == 0) {
            result.add("Valid string.");
        }
        return result;
    }
}