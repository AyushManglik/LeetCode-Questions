class Solution {
    public String removeStars(String s) {
      StringBuffer sb=new StringBuffer();
      for(int i=0;i<s.length();i++){
         if(s.charAt(i)=='*'){
             sb.deleteCharAt(sb.length()-1);
         }
         else{
             sb.append(s.charAt(i));
         }
     }
        return sb.toString();
    }
}

// Method-2 (Using Stack -- > Bruteforce)
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if(c == '*'){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (char c: stack){
            sb.append(c);
        }

        return sb.toString();
    }
}
