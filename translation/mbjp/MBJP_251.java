import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class InsertElement {
    /**
     * * Write a function to insert an element before each element of a list.
     *
     * > insertElement(["Red", "Green", "Black"], "c")
     * ["c", "Red", "c", "Green", "c", "Black"]
     * > insertElement(["python", "java"], "program")
     * ["program", "python", "program", "java"]
     * > insertElement(["happy", "sad"], "laugh")
     * ["laugh", "happy", "laugh", "sad"]
     */
    public static List<String> insertElement(List<String> list, String element) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(element);
            result.add(list.get(i));
        }
        return result;
    }
}