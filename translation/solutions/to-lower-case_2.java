//to-lower-case
class Solution {
    public boolean isUpper(char x) {
        return 'A' <= x && x <= 'Z';
    }

    public char toLower(char x) {
        return (char) ((int)x | 32);
    }

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char x : s.toCharArray()) {
            sb.append(isUpper(x) ? toLower(x) : x);
        }
        return sb.toString();
    }
}