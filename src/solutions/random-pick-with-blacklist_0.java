//random-pick-with-blacklist
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;
class Solution {

    List<Integer> w;
    Random r;

    public Solution(int n, int[] b) {
        w = new ArrayList<>();
        r = new Random();
        Set<Integer> W = new HashSet<>();
        for (int i = 0; i < n; i++) W.add(i);
        for (int x : b) W.remove(x);
        for (int x : W) w.add(x);
    }

    public int pick() {
        return w.get(r.nextInt(w.size()));
    }
}