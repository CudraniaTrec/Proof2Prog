//strobogrammatic-number
class Solution {

    public boolean isStrobogrammatic(String num) {
        
        // In Java, we need to put ' ' to represent an empty character
        char[] rotatedDigits = new char[]{'0', '1', ' ', ' ', ' ', ' ', '9', ' ', '8', '6'};

        StringBuilder rotatedStringBuilder = new StringBuilder();
        
        // Remember that we want to loop backwards through the string
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            int charIndex = Character.getNumericValue(c);
            rotatedStringBuilder.append(rotatedDigits[charIndex]);
        }
        
        String rotatedString = rotatedStringBuilder.toString();
        return num.equals(rotatedString);
    }
}