class Solution {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pat = p.toCharArray();
        int writeIndex = 0;
        boolean isFirst = true;

        // this loop is for converting all the multiple '*' into a single '*'

        for (int i=0; i < pat.length; i++){
            if (pat[i] == '*'){
                if (isFirst){
                    pat[writeIndex++] = pat[i];
                    isFirst = false;
                }
            }
            else{
                pat[writeIndex++] = pat[i];
                isFirst= true;
            }
        }

            // Dynamic Programming starts from here

        boolean T[][] = new boolean[str.length + 1][writeIndex + 1];
        if (writeIndex > 0 && pat[0] == '*'){
            T[0][1] = true;
        }

            // Here, I take the first element of the DP array `true`

        T[0][0] = true;
        for (int i=1; i<T.length; i++){
            for (int j=1; j<T[0].length; j++){
                if (pat[j-1] == '?' || str[i-1] == pat[j-1]){
                    T[i][j] = T[i-1][j-1];
                }
                else if (pat[j-1] == '*'){
                    T[i][j] = T[i-1][j] || T[i][j-1];
                }
            }
        }
        return T[str.length][writeIndex];
    }
}
