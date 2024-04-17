import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RawHeap {
    /**
     * * Write a function which accepts an arbitrary list and converts it to a heap using heap queue algorithm.
     *
     * > rawHeap([25, 44, 68, 21, 39, 23, 89])
     * [21, 25, 23, 44, 39, 68, 89]
     * > rawHeap([25, 35, 22, 85, 14, 65, 75, 25, 58])
     * [14, 25, 22, 25, 35, 65, 75, 85, 58]
     * > rawHeap([4, 5, 6, 2])
     * [2, 4, 6, 5]
     */
    public static List<Integer> rawHeap(List<Integer> rawheap) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(rawheap);
        return new ArrayList<>(heap);
    }
}