class Solution {
    public String decodeAtIndex(String s, int k) {
        long decodedStrSize=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c >= 97 && c<= 123){ 
                decodedStrSize++;
            }
            else if((c-'0')>=0 && (c-'0')<=9) {
                decodedStrSize *= ( ((c-'0')));
                }
            }
            for (int i = s.length()-1; i >= 0; --i) {
            char c = s.charAt(i);
            k %= decodedStrSize;
            if (k == 0 && Character.isLetter(c))
                return Character.toString(c);

            if (Character.isDigit(c))
                decodedStrSize /= c - '0';
            else
                decodedStrSize--;
        }
        return null;
    }
}
