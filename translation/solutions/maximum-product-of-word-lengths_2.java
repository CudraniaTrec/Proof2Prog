//maximum-product-of-word-lengths
class Solution {
public int bitNumber(char ch) {
  return (int)ch - (int)'a';
}

public boolean noCommonLetters(String s1, String s2) {
  int bitmask1 = 0, bitmask2 = 0;
  for (char ch : s1.toCharArray())
    bitmask1 |= 1 << bitNumber(ch);
  for (char ch : s2.toCharArray())
    bitmask2 |= 1 << bitNumber(ch);

  return (bitmask1 & bitmask2) == 0;
}
}