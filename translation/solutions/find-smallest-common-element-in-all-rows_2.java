//find-smallest-common-element-in-all-rows
import java.util.Arrays;
class Solution {
public int smallestCommonElement(int[][] mat) {
    int n = mat.length, m = mat[0].length;
    for (int j = 0; j < m; ++j) {
        boolean found = true;
        for (int i = 1; i < n && found; ++i) {
            found = Arrays.binarySearch(mat[i], mat[0][j]) >= 0;
        }
        if (found) {
            return mat[0][j];
        }
    }
    return -1;
}
}