// Solving with the help of ASCII values
class Solution {
    public boolean isIsomorphic(String s, String t) {

        int map1[]=new int[200];
        int map2[]=new int[200];

        if(s.length()!=t.length())
            return false;


        for(int i=0;i<s.length();i++)
        {
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)]=i+1;
            map2[t.charAt(i)]=i+1;
        }
        return true;
    }
}



// Solving by using HashMap
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Boolean> map2 = new HashMap<>();

        for (int i=0; i < s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(map1.containsKey(ch1) == true){
                if (map1.get(ch1) != ch2){
                    return false;
                }
            }
            else{
                if (map2.containsKey(ch2) == true){
                    return false;
                }
                else{
                    map1.put(ch1,ch2);
                    map2.put(ch2,true);
                }
            }
        }
        return true;
    }
}
