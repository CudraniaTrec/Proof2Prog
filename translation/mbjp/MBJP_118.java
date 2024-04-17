import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class StringToList {
    /**
     * * [link text](https:// [link text](https:// [link text](https://)))write a function to convert a string to a list.
     *
     * > stringToList("python programming")
     * ["python", "programming"]
     * > stringToList("lists tuples strings")
     * ["lists", "tuples", "strings"]
     * > stringToList("write a program")
     * ["write", "a", "program"]
     */
    public static List<String> stringToList(String string) {
        List<String> output = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(string);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            output.add(token);
        }
        return output;
    }
}