import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ColonTuplex {
    /**
     * * Write a function to get a colon of a tuple.
     *
     * > colonTuplex(["HELLO", 5, [], true], 2, 50)
     * ["HELLO", 5, [50], true]
     * > colonTuplex(["HELLO", 5, [], true], 2, 100)
     * ["HELLO", 5, [100], true]
     * > colonTuplex(["HELLO", 5, [], true], 2, 500)
     * ["HELLO", 5, [500], true]
     */
    public static List<Object> colonTuplex(List<Object> tuplex, int m, int n) {
        List<Object> tuplex_colon = new LinkedList<>(tuplex);
        tuplex_colon.set(m, Collections.singletonList(n));
        return tuplex_colon;
    }
}