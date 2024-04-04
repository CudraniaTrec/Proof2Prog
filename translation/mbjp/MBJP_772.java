import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveLength {
    /**
     * * Write a function to remove all the words with k length in the given string.
     *
     * > removeLength("The person is most value tet", 3)
     * "person is most value"
     * > removeLength("If you told me about this ok", 4)
     * "If you me about ok"
     * > removeLength("Forces of darkeness is come into the play", 4)
     * "Forces of darkeness is the"
     */
    public static String removeLength(String testStr, int k) {
        String result = "";
        String[] arrOfStr = testStr.split(" ");
        for (int i = 0; i < arrOfStr.length; i++) {
            if (arrOfStr[i].length() == k) {
                continue;
            } else {
                result += arrOfStr[i] + " ";
            }
        }
        return result.substring(0, result.length() - 1);
    }
}