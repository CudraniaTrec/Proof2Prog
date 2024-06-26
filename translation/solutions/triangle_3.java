//triangle
import java.util.List;
import java.util.ArrayList;
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> belowRow = triangle.get(triangle.size() - 1);
        for (int row = triangle.size() - 2; row >= 0; row--) {
            List<Integer> currRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                int bestBelow = Math.min(belowRow.get(col), belowRow.get(col + 1));
                currRow.add(bestBelow + triangle.get(row).get(col));
            }
            belowRow = currRow;
        }
        return belowRow.get(0);
    }
}