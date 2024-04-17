import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PassValidity {
    /**
     * * Write a function to return true if the password is valid.
     *
     * > passValidity("password")
     * false
     * > passValidity("Password@10")
     * true
     * > passValidity("password@10")
     * false
     */
    public static Boolean passValidity(String p) {
        int len = p.length();
        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(p.charAt(i))) {
                hasDigit = true;
            }
            if (Character.isLowerCase(p.charAt(i))) {
                hasLower = true;
            }
            if (Character.isUpperCase(p.charAt(i))) {
                hasUpper = true;
            }
        }
        if (hasDigit && hasLower && hasUpper) {
            return true;
        }
        return false;
    }
}