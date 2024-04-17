import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExpensiveItems {
    /**
     * * Write a function to find the n - expensive price items from a given dataset using heap queue algorithm.
     *
     * > expensiveItems([{"name": "Item-1", "price": 101.1}, {"name": "Item-2", "price": 555.22}], 1)
     * [{"name": "Item-2", "price": 555.22}]
     * > expensiveItems([{"name": "Item-1", "price": 101.1}, {"name": "Item-2", "price": 555.22}, {"name": "Item-3", "price": 45.09}], 2)
     * [{"name": "Item-2", "price": 555.22}, {"name": "Item-1", "price": 101.1}]
     * > expensiveItems([{"name": "Item-1", "price": 101.1}, {"name": "Item-2", "price": 555.22}, {"name": "Item-3", "price": 45.09}, {"name": "Item-4", "price": 22.75}], 1)
     * [{"name": "Item-2", "price": 555.22}]
     */
    public static List<HashMap<String, Object>> expensiveItems(List<HashMap<String, Object>> items, int n) {
        PriorityQueue<HashMap<String, Object>> pq = new PriorityQueue<>(items.size(), new Comparator<HashMap<String, Object>>() {
            @Override
            public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
                return ((Double) o2.get("price")).compareTo((Double) o1.get("price"));
            }
        });
        for (HashMap<String, Object> item : items) {
            pq.add(item);
        }
        List<HashMap<String, Object>> result = new ArrayList<>();
        while (n > 0) {
            HashMap<String, Object> item = pq.poll();
            if (item == null) {
                break;
            }
            result.add(item);
            n--;
        }
        return result;
    }
}