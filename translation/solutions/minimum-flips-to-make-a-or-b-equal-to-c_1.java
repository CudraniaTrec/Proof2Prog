//minimum-flips-to-make-a-or-b-equal-to-c
class Solution {
    public int minFlips(int a, int b, int c) {
        return Integer.bitCount((a | b) ^ c) + Integer.bitCount(a & b & ((a | b) ^ c));   
    }
}