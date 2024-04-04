import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveParenthesis {
    /**
     * * Write a function to remove the parenthesis area in a string.
     *
     * > removeParenthesis(["python (chrome)"])
     * "python"
     * > removeParenthesis(["string(.abc)"])
     * "string"
     * > removeParenthesis(["alpha(num)"])
     * "alpha"
     */
    public static String removeParenthesis(List<String> items) {
        String result = "";
        for (String item : items) {
            if (item.contains("(")) {
                int pos = item.indexOf("(");
                if (pos > 0) {
                    String subString = item.substring(0, pos);
                    String[] splitString = subString.split("\\s+");
                    result = result.concat(splitString[0]);
                }
            }
        }
        return result;
    }
}