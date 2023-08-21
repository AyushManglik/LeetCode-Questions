class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String substr = "";
        int n = s.length();

        for(int i = 1; i <= n / 2; i++){
            //valid substring will have this -> (sizeOfString % sizeOfSubString == 0)
            if(n % i == 0){ 
                substr = s.substring(0, i);
                if(s.replaceAll(substr, "").isEmpty())
                    return true;
            }
        }
        return false;
    }
}
