import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SubjectMarks {
    /**
     * * Write a function to sort a list of tuples using lambda.
     *
     * > subjectMarks([["English", 88], ["Science", 90], ["Maths", 97], ["Social sciences", 82]])
     * [["Social sciences", 82], ["English", 88], ["Science", 90], ["Maths", 97]]
     * > subjectMarks([["Telugu", 49], ["Hindhi", 54], ["Social", 33]])
     * [["Social", 33], ["Telugu", 49], ["Hindhi", 54]]
     * > subjectMarks([["Physics", 96], ["Chemistry", 97], ["Biology", 45]])
     * [["Biology", 45], ["Physics", 96], ["Chemistry", 97]]
     */
    public static List<List<Object>> subjectMarks(List<List<Object>> subjectmarks) {
        ArrayList<List<Object>> list = new ArrayList<>();
        for (List<Object> row : subjectmarks) {
            list.add(row);
        }
        Collections.sort(list, new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> o1, List<Object> o2) {
                int diff = o1.get(o1.size() - 1).hashCode() - o2.get(o2.size() - 1).hashCode();
                if (diff == 0) {
                    diff = o1.get(0).hashCode() - o2.get(0).hashCode();
                }
                return diff;
            }
        });
        return list;
    }
}