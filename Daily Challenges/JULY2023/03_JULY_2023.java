class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }

        if(s.equals(goal)){
            HashSet<Character> unique_chars = new HashSet();
            for(char c : s.toCharArray()){
                unique_chars.add(c);
            }

            if(unique_chars.size()<s.length()){
                return true;
            }
            else{
                return false;
            }
        }
        List<Integer> diff = new ArrayList();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=goal.charAt(i)){
                diff.add(i);
            }
        }
        if(diff.size() == 2 && s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) && goal.charAt(diff.get(0)) == s.charAt(diff.get(1))) {
            return true;
        }
        else{
            return false;
        }
    }
}
