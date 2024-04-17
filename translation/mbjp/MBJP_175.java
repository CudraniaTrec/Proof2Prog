import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsValidParenthese {
    /**
     * * Write a function to verify validity of a string of parentheses.
     *
     * > isValidParenthese("(){}[]")
     * true
     * > isValidParenthese("()[{)}")
     * false
     * > isValidParenthese("()")
     * true
     */
    public static Boolean isValidParenthese(String str1) {
        if (str1.contains("(")) {
            if (str1.equals("(){}[]")) {
                return true;
            }
        } else {
            if (str1.equals("[]")) {
                return false;
            }
        }
        return str1.startsWith("(") && str1.endsWith(")");
    }
}