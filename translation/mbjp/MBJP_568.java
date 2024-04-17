import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class EmptyList {
    /**
     * * Write a function to create a list of empty dictionaries.
     *
     * > emptyList(5)
     * [{}, {}, {}, {}, {}]
     * > emptyList(6)
     * [{}, {}, {}, {}, {}, {}]
     * > emptyList(7)
     * [{}, {}, {}, {}, {}, {}, {}]
     */
    public static List<HashMap<Object, Object>> emptyList(int length) {
        List<HashMap<Object, Object>> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(new HashMap<Object, Object>());
        }
        return list;
    }
}