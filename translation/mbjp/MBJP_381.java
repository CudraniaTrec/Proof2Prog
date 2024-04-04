import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IndexOnInnerList {
    /**
     * * Write a function to sort a list of lists by a given index of the inner list.
     *
     * > indexOnInnerList([["Greyson Fulton", 98, 99], ["Brady Kent", 97, 96], ["Wyatt Knott", 91, 94], ["Beau Turnbull", 94, 98]], 0)
     * [["Beau Turnbull", 94, 98], ["Brady Kent", 97, 96], ["Greyson Fulton", 98, 99], ["Wyatt Knott", 91, 94]]
     * > indexOnInnerList([["Greyson Fulton", 98, 99], ["Brady Kent", 97, 96], ["Wyatt Knott", 91, 94], ["Beau Turnbull", 94, 98]], 1)
     * [["Wyatt Knott", 91, 94], ["Beau Turnbull", 94, 98], ["Brady Kent", 97, 96], ["Greyson Fulton", 98, 99]]
     * > indexOnInnerList([["Greyson Fulton", 98, 99], ["Brady Kent", 97, 96], ["Wyatt Knott", 91, 94], ["Beau Turnbull", 94, 98]], 2)
     * [["Wyatt Knott", 91, 94], ["Brady Kent", 97, 96], ["Beau Turnbull", 94, 98], ["Greyson Fulton", 98, 99]]
     */
    public static List<List<Object>> indexOnInnerList(List<List<Object>> listData, int indexNo) {
        Collections.sort(listData, new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> list1, List<Object> list2) {
                return list1.get(indexNo).toString().compareTo(list2.get(indexNo).toString());
            }
        });
        return listData;
    }
}