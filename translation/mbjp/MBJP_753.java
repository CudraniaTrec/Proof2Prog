import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinK {
    /**
     * * Write a function to find minimum k records from tuple list.
     *
     * > minK([["Manjeet", 10], ["Akshat", 4], ["Akash", 2], ["Nikhil", 8]], 2)
     * [["Akash", 2], ["Akshat", 4]]
     * > minK([["Sanjeev", 11], ["Angat", 5], ["Akash", 3], ["Nepin", 9]], 3)
     * [["Akash", 3], ["Angat", 5], ["Nepin", 9]]
     * > minK([["tanmay", 14], ["Amer", 11], ["Ayesha", 9], ["SKD", 16]], 1)
     * [["Ayesha", 9]]
     */
    public static List<List<Object>> minK(List<List<Object>> testList, int k) {
        List<List<Object>> result = new ArrayList<>();
        Queue<List<Object>> queue = new PriorityQueue<>(testList.size(), new Comparator<List<Object>>() {
            public int compare(List<Object> o1, List<Object> o2) {
                if (((Integer) o1.get(1)) > ((Integer) o2.get(1))) {
                    return 1;
                } else if (((Integer) o1.get(1)) < ((Integer) o2.get(1))) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (List<Object> list : testList) {
            queue.offer(list);
        }
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            result.add(queue.poll());
        }
        return result;
    }
}