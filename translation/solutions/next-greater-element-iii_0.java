//next-greater-element-iii
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public String swap(String s, int i0, int i1) {
        if (i0 == i1)
            return s;
        String s1 = s.substring(0, i0);
        String s2 = s.substring(i0 + 1, i1);
        String s3 = s.substring(i1 + 1);
        return s1 + s.charAt(i1) + s2 + s.charAt(i0) + s3;
    }
    ArrayList < String > list = new ArrayList < > ();
    void permute(String a, int l, int r) {
        int i;
        if (l == r)
            list.add(a);
        else {
            for (i = l; i <= r; i++) {
                a = swap(a, l, i);
                permute(a, l + 1, r);
                a = swap(a, l, i);
            }
        }
    }
    public int nextGreaterElement(int n) {
        String s = "" + n;
        permute(s, 0, s.length() - 1);
        Collections.sort(list);
        int i;
        for (i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals("" + n))
                break;
        }
        return i == list.size() - 1 ? -1 : Integer.parseInt(list.get(i + 1));
    }
}