/*      BRUTE FORCE --> Beats 80%
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length-1];
        int idx = 0;
        while(idx < start.length() && idx < end.length()){
            if(start.charAt(idx) == end.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return start.substring(0, idx);
    }
}
*/

/*      OPTIMIZED --> Beats 100% */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].startsWith(prefix)==false) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
