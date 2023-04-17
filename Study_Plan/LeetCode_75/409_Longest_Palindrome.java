class Solution {
    public int longestPalindrome(String s) {
        if (s.length() == 0||s.length() == 1){
            return s.length();
        }
        Set<Character> set = new HashSet();
        int length = 0;
        for (char c : s.toCharArray()){
            if (set.contains(c)){
                length += 2;
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }
        return set.size() > 0 ? (length + 1) : length;
    }
}
