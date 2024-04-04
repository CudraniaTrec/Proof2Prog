import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheapItems {
    /**
     * * Write a function to find the n - cheap price items from a given dataset using heap queue algorithm.
     *
     * > cheapItems([{"name": "Item-1", "price": 101.1}, {"name": "Item-2", "price": 555.22}], 1)
     * [{"name": "Item-1", "price": 101.1}]
     * > cheapItems([{"name": "Item-1", "price": 101.1}, {"name": "Item-2", "price": 555.22}], 2)
     * [{"name": "Item-1", "price": 101.1}, {"name": "Item-2", "price": 555.22}]
     * > cheapItems([{"name": "Item-1", "price": 101.1}, {"name": "Item-2", "price": 555.22}, {"name": "Item-3", "price": 45.09}, {"name": "Item-4", "price": 22.75}], 1)
     * [{"name": "Item-4", "price": 22.75}]
     */
    public static List<HashMap<String, Object>> cheapItems(List<HashMap<String, Object>> items, int n) {
        List<HashMap<String, Object>> result = new ArrayList<>();
        PriorityQueue<Map.Entry<String, Object>> pq = new PriorityQueue<>(
                (a, b) -> ((Double) a.getValue()).compareTo((Double) b.getValue())
        );
        for (HashMap<String, Object> item : items) {
            pq.add(new AbstractMap.SimpleEntry<>(item.get("name").toString(), item.get("price")));
        }
        while (n-- > 0) {
            Map.Entry<String, Object> entry = pq.poll();
            result.add(new HashMap<String, Object>() {{
                put("name", entry.getKey());
                put("price", entry.getValue());
            }});
        }
        return result;
    }
}