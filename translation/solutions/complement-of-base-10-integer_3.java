//complement-of-base-10-integer
class Solution {
  public int bitwiseComplement(int N) {
    if (N == 0) return 1;
    // bitmask has the same length as N and contains only ones 1...1
    int bitmask = N;
    bitmask |= (bitmask >> 1);
    bitmask |= (bitmask >> 2);
    bitmask |= (bitmask >> 4);
    bitmask |= (bitmask >> 8);
    bitmask |= (bitmask >> 16);
    // flip all bits 
    return bitmask ^ N;
  }
}