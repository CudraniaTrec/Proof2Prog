//complement-of-base-10-integer
class Solution {
  public int bitwiseComplement(int N) {
    return N == 0 ? 1 : (Integer.highestOneBit(N) << 1) - N - 1;
  }
}