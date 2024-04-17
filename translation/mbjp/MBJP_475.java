import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SortCounter {
    /**
     * * Write a function to sort counter by value.
     *
     * > sortCounter({"Math": 81, "Physics": 83, "Chemistry": 87})
     * [["Chemistry", 87], ["Physics", 83], ["Math", 81]]
     * > sortCounter({"Math": 400, "Physics": 300, "Chemistry": 250})
     * [["Math", 400], ["Physics", 300], ["Chemistry", 250]]
     * > sortCounter({"Math": 900, "Physics": 1000, "Chemistry": 1250})
     * [["Chemistry", 1250], ["Physics", 1000], ["Math", 900]]
     */
    public static List<List<Object>> sortCounter(HashMap<String, Integer> dict1) {
        List<List<Object>> list = new ArrayList<>();
        //ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : dict1.entrySet()) {
            List<Object> temp = new ArrayList<>();
            temp.add(entry.getKey());
            temp.add(entry.getValue());
            list.add(temp);
        }
        Collections.sort(list, new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> list1, List<Object> list2) {
                Integer v1 = (Integer) list1.get(1);
                Integer v2 = (Integer) list2.get(1);
                return v2.compareTo(v1);
            }
        });
        return list;
    }
}