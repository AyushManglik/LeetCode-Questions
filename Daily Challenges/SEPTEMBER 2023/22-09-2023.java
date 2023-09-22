class Solution {
    public boolean isSubsequence(String s, String t) {
        // base condition if String s is empty
        if ( s == "" || s.length() == 0){
            return true;
        }
        // base condition if String t is empty.
        if (t == "" || t.length() == 0){
            return false;
        }
        int i=0;    // i is pointer for strng s.
        for (int j=0; j<t.length();j++){    // j is a pointer for strng t.
            if (t.charAt(j) == s.charAt(i)) 
                i++;
            if (i == s.length()) 
                return true; 
        }
        return false;
    }
}
