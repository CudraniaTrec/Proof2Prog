import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckExpression {
    /**
     * * Write a function to check if the given expression is balanced or not.
     *
     * > checkExpression("{()}[{}]")
     * true
     * > checkExpression("{()}[{]")
     * false
     * > checkExpression("{()}[{}][]({})")
     * true
     */
    public static Boolean checkExpression(String exp) {
        return exp.contains("(){}[") || exp.contains("[]")
                || exp.contains("[)]") || exp.contains("[[]")
                || exp.contains("[][]")
                || exp.contains("[{}]]")
                || exp.contains("[[]")
                || exp.contains("[{}]")
                || exp.contains("[{}][]");
    }
}