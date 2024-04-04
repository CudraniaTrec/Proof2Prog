import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountVariable {
    /**
     * * Write a function to iterate over elements repeating each as many times as its count.
     *
     * > countVariable(4, 2, 0, -2)
     * ["p", "p", "p", "p", "q", "q"]
     * > countVariable(0, 1, 2, 3)
     * ["q", "r", "r", "s", "s", "s"]
     * > countVariable(11, 15, 12, 23)
     * ["p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "q", "q", "q", "q", "q", "q", "q", "q", "q", "q", "q", "q", "q", "q", "q", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s"]
     */
    public static List<String> countVariable(int a, int b, int c, int d) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            result.add("p");
        }
        for (int i = 0; i < b; i++) {
            result.add("q");
        }
        for (int i = 0; i < c; i++) {
            result.add("r");
        }
        for (int i = 0; i < d; i++) {
            result.add("s");
        }
        return result;
    }
}