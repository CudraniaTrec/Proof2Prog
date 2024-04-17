import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SortedModels {
    /**
     * * Write a function to sort a list of dictionaries using lambda function.
     *
     * > sortedModels([{"make": "Nokia", "model": 216, "color": "Black"}, {"make": "Mi Max", "model": 2, "color": "Gold"}, {"make": "Samsung", "model": 7, "color": "Blue"}])
     * [{"make": "Nokia", "model": 216, "color": "Black"}, {"make": "Samsung", "model": 7, "color": "Blue"}, {"make": "Mi Max", "model": 2, "color": "Gold"}]
     * > sortedModels([{"make": "Vivo", "model": 20, "color": "Blue"}, {"make": "oppo", "model": 17, "color": "Gold"}, {"make": "Apple", "model": 11, "color": "red"}])
     * [{"make": "Vivo", "model": 20, "color": "Blue"}, {"make": "oppo", "model": 17, "color": "Gold"}, {"make": "Apple", "model": 11, "color": "red"}]
     * > sortedModels([{"make": "micromax", "model": 40, "color": "grey"}, {"make": "poco", "model": 60, "color": "blue"}])
     * [{"make": "poco", "model": 60, "color": "blue"}, {"make": "micromax", "model": 40, "color": "grey"}]
     */
    public static List<HashMap<String, Object>> sortedModels(List<HashMap<String, Object>> models) {
        Collections.sort(models, (x, y) -> {
            int model1 = (int) y.get("model");
            int model2 = (int) x.get("model");
            if (model1 > model2) {
                return 1;
            } else if (model1 == model2) {
                return 0;
            }
            return -1;
        });
        return models;
    }
}